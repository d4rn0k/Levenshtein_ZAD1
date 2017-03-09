class Levenshtein {


    // From http://rosettacode.org/wiki/Levenshtein_distance#Java
    // TODO: JAWOR REFACTOR
    static int distance(String left, String right) {
        left = left.toLowerCase();
        right = right.toLowerCase();
        // i == 0
        int[] costs = new int[right.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= left.length(); i++) {
            // j == 0; nw = lev(i - 1, j)
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= right.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), left.charAt(i - 1) == right.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[right.length()];
    }

}