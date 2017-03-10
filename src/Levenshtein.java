class Levenshtein {


    static int distance(String left, String right) {
        int[] costs = new int[right.length() + 1];

        left = left.toLowerCase();
        right = right.toLowerCase();

        for (int i = 0; i < costs.length; i++) {
            costs[i] = i;
        }

        for (int i = 1; i <= left.length(); i++) {

            costs[0] = i;
            int temp = i - 1;

            for (int j = 1; j <= right.length(); j++) {
                int currentMin = Math.min(1 + Math.min(costs[j], costs[j - 1]),
                        left.charAt(i - 1) == right.charAt(j - 1) ? temp : temp + 1);
                temp = costs[j];
                costs[j] = currentMin;
            }
        }

        return costs[right.length()];
    }

}