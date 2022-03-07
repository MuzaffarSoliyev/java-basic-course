enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}

interface TextAnalyzer {
    Label processText(String text);
}

public abstract class KeywordAnalyzer implements TextAnalyzer{
    abstract protected String[] getKeywords();

    abstract protected Label getLabel();

    @Override
    public Label processText(String text) {
        for (String word: getKeywords()){
            if (text.contains(word))
                return getLabel();
        }
        return Label.OK;
    }
}


