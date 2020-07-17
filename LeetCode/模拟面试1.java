class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        String[] arr = sentence.split("\\s+");//将sentence按空格切分
        if (arr.length == 0) {
            return sentence;
        }
        String temp;
        for (int i = dict.length - 1; i >= 0; i--) {//将dict按长度排序
            int flag = 1;
            for (int j = 0; j < i; j++) {
                if (dict.get(j).length > dict.get(j + 1)) {
                    temp = dict.get(j);
                    dict.get(j) = dict.get(j + 1);
                    dict.get(j + 1) = temp;
                    flag = 0;
                }
            }
            if (flag == 1) {
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < dict.size(); j++) {
                temp = dict.get(j);
                if (arr[i].substring(0, temp.length).equals(temp)) {
                    arr[i] = temp;
                    break;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            result.append(arr[i] + " ");
        }
        result.append(arr[arr.length - 1]);
        return result.toSting();
    }
}