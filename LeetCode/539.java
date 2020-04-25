class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        List t = new ArrayList();
        int i;
        for (i = 0; i < timePoints.size(); i++) {
            t.add(convert(timePoints.get(i)));
        }
        t = mergesort(t);
        int min = (int) t.get(0) + 1440 - (int) t.get(t.size() - 1);
        for (i = 0; i < t.size() - 1; i++) {
            if ((int) t.get(i + 1) - (int) t.get(i) < min) {
                min = (int) t.get(i + 1) - (int) t.get(i);
            }
            if (min == 0) {
                return 0;
            }
        }
        return min;
    }

    public List mergesort(List t) {
        List result = new ArrayList();
        if (t.size() == 1) {
            result.add(t.get(0));
            return result;
        }
        int mid = t.size() / 2;
        List left = t.subList(0, mid);
        List right = t.subList(mid, t.size());
        int i = 0;
        int j = 0;
        left = mergesort(left);
        right = mergesort(right);
        while (i < left.size() || j < right.size()) {
            if (i < left.size() && j < right.size()) {
                if ((int) left.get(i) < (int) right.get(j)) {
                    result.add(left.get(i));
                    i = i + 1;
                } else {
                    result.add(right.get(j));
                    j = j + 1;
                }
            } else {
                while (i < left.size()) {
                    result.add(left.get(i));
                    i = i + 1;
                }
                while (j < right.size()) {
                    result.add(right.get(j));
                    j = j + 1;
                }
            }
        }
        return result;
    }

    public int convert(String s) {
        int h, m;
        h = Integer.parseInt(s.substring(0, s.indexOf(":")));//hour
        m = Integer.parseInt(s.substring(s.indexOf(":") + 1));//minute
        return h * 60 + m;
    }
}