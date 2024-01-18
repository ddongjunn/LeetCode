import java.util.ArrayList;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        
        for(String log : logs){
            if(Character.isDigit(log.split(" ")[1].charAt(0))){
                digitLogs.add(log);
            }else{
                letterLogs.add(log);
            }
        }
        
        letterLogs.sort((s1, s2) -> {
            String s1x[] = s1.split(" ", 2);
            String s2x[] = s2.split(" ", 2);
            
            int compared = s1x[1].compareTo(s2x[1]);
            if(compared == 0){ //문자가 동일할 경우 식별자 순
                return s1x[0].compareTo(s2x[0]);
            }else{
                return compared;
            }
        });
        
        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);
    }
}