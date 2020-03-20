package io.viren.interviews;

public class Panagram {

    public static void main(String[] args) {
        PanagramDetector pd = new PanagramDetector();
        boolean success = true;

        success = success && "adglvyz".equals(pd.findMissingLetters("The quick brown fox jumps"));
        success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));

        if (success) {
            System.out.println("Pass ");
        } else {
            System.out.println("Failed");
        }
    }

    private static class PanagramDetector {

        public String findMissingLetters(String input) {
            input = input.toLowerCase();
            String alph = "abcdefghijklmnopqrstuvwxyz";
            int max = 26;

            for (int i = 0; i < max; i++) {
                int index = input.indexOf(alph.charAt(i));
                if (index != -1) {
                    alph = alph.substring(0, i) + alph.substring(i + 1);
                    System.out.println("Temp alph " + alph);
                    i--;
                    max--;
                }
            }
            return alph;
        }
    }
}
