public class CheckLabels {

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer ta: analyzers){
            if(!ta.processText(text).equals(Label.OK)){
                return ta.processText(text);
            }
        }
        return Label.OK;
    }

    public static void main(String[] args) {

        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] analyzers = {new SpamAnalyzer(spamKeywords), new NegativeTextAnalyzer(), new TooLongTextAnalyzer(commentMaxLength)};

        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";

        for (String t: tests){
            System.out.println(checkLabels(analyzers, t));
        }
    }
}
