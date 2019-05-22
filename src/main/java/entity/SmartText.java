package entity;

public abstract class SmartText implements CompositeWord{

    private final TextParse textParse;

    private SmartText parent;

    private SmartText lastChild;

    protected SmartText(TextParse textParse) {
        this.textParse = textParse;
    }

    public void smartAddEmployee(SmartText text) {
        int compare = Integer.compare(this.textParse.level, text.textParse.level);
        switch (compare) {
            case 0:
                if (parent != null) {
                    parent.add(text);
                    text.parent = parent;
                    parent.lastChild = text;
                }
                break;
            case 1:
                if (parent != null) {
                    parent.smartAddEmployee(text);
                }
                break;
            case -1:
                if (lastChild == null || lastChild.textParse.level == text.textParse.level) {
                    add(text);
                    text.parent = this;
                    lastChild = text;
                } else {
                    lastChild.smartAddEmployee(text);
                }
                break;
            default:
                throw new IllegalStateException("Should never occur");
        }
    }

    /**
     * Here we will find our root employee
     * @return employee
     */
    public SmartText findRoot() {
        if (this.parent == null) {
            return this;
        } else {
            SmartText text = this.parent;
            while (text.parent != null) {
                text = text.parent;
            }
            return text;
        }
    }


    private enum TextParse{
        TEXT("text", 1),
        PARAGRAPH("paragraph", 2),
        SENTENSE("sentense", 3),
        WORD("word", 4);


        private final int level;
        private final String title;

        TextParse(String title, int level){
            this.level = level;
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public int getLevel() {
            return level;
        }
    }
}
