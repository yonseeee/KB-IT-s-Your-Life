package week1;


class Solution {
    public static void main(String[] args) {
//        String[] participants = {"marina", "josipa", "nikola", "vinko", "filipa"};
//        String[] completion = {"josipa", "filipa", "marina", "nikola"};
//        System.out.println(solution(participants, completion));

//        String[]phone={"119", "97674223", "1195524421"};
//        String[]phone1={"123", "456", "789"};
//        String[]phone2={"12","123","1235","567","88"};
//        System.out.println(solution(phone));
//        System.out.println(solution(phone1));
//        System.out.println(solution(phone2));

//        String s="()[]{}";
//
//        System.out.println(isValid(s));
//        int[]array={1,2,3,2,3};
//        int[]result=solution(array);
//        for(int elem: result){
//            System.out.println(elem);
//        }

        int[]temperature={8,8,8,8,8,9};
        int[]result=dailyTemperatures(temperature);

        for(int elem: result){
            System.out.println(elem);
        }

//        System.out.println(        isValid("(()("));

    }

//    public int[] twoSum(int[] nums, int target) {
//        int[] res={};
//        for(int i=0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[i]+nums[j]==target){
//
//                    return new int[]{i,j};
//                }
//            }
//        }
//        return res;
//    }

//    public static int solution(int[] d, int budget) {
//        int sum = 0, cnt = 0;
//        Arrays.sort(d);
//        for (int i = 0; i < d.length; i++) {
//            sum += d[i];
//            cnt++;
//            if (sum > budget) {
//                sum -= budget;
//                cnt--;
//                break;
//            } else if (sum == budget) {
//                break;
//            }
//        }
//        return cnt;
//    }

//    public static int solution(int[] nums) {
//        int total = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    int result = nums[i] + nums[j] + nums[k];
//
//                    int cnt = 0;
//                    for (int index = 1; index <= result; index++) {
//                        if (result % index == 0) {
//                            cnt++;
//                        }
//                    }
//                    if (cnt == 2) total++;
//
//                }
//            }
//        }
//        return total;
//    }

//    public static String solution(String[] participant, String[] completion) {
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//
//        String result = "";
//        int i;
//        for (i = 0; i < completion.length; i++) {
//            if (!participant[i].equals(completion[i])) {
//                result = participant[i];
//                return result;
//            }
//        }
//        return participant[i];
//    }
//
//    public static boolean isValid(String s) {
//
//        Deque<Character> stack = new ArrayDeque<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '(' || c == '[' || c == '{') {
//                stack.push(c);
//            } else {
//                if (!stack.isEmpty()) {
//                    char c1 = stack.pop();
//                    if (!(c == ')' && c1 == '(' || c == ']' && c1 == '[' || c == '}' && c1 == '{')) {
//                        return false;
//                    }
//                }else{
//                    return false;
//                }
//            }
//        }
//        if (stack.isEmpty()) return true;
//        return false;
//
//    }
//
//    public static boolean solution(String[] phone_book) {
//        Map<String, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < phone_book.length; i++) {
//            map.put(phone_book[i], i);
//        }
//
//        for (int i = 0; i < phone_book.length; i++) {
//            for (int j = 0; j < phone_book[i].length(); j++) {
//                if (map.containsKey(phone_book[i].substring(0, j))) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//    public static int[] solution(int[] prices) {
//        int[]answer=new int[prices.length];
//        for(int i = 0; i < prices.length; i++){
//            for(int j = i+1; j < prices.length; j++){
//                answer[i]++;
//                if(prices[0]>prices[j]){
//                    break;
//                }
//            }
//        }
//        return answer;
//    }

    public static int[] dailyTemperatures(int[] temperatures) {

        int[]answer=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            boolean flag=true;
            for(int j=i+1;j<temperatures.length;j++){
                answer[i]++;
                flag=true;
                if(temperatures[i]<temperatures[j]){
                    flag=false;
                    break;
                }
            }
            if(flag)answer[i]=0;
        }
        return answer;
    }
}