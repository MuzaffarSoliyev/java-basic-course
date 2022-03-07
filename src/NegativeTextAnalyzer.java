public class NegativeTextAnalyzer extends KeywordAnalyzer {
    @Override
    protected String[] getKeywords() {
        String[] keywords = {
                ":(", "=(", ":|"
        };
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
