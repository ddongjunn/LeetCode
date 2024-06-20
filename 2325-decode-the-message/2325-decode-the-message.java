class Solution {
    public String decodeMessage(String key, String message) {
        char[] keys = key.replaceAll(" ", "").toCharArray();
        
        Map<Character, Character> map = new HashMap();
        int ascii = 97;
        for(char k : keys) {
            if(!map.containsKey(k)) {
                map.put(k, (char) ascii++);
            }
        }
    
        StringBuilder sb = new StringBuilder();
        for(char ch : message.toCharArray()) {
            if(ch == ' ') {
                sb.append(" ");
                continue;
            }
            sb.append(ch == ' ' ? " " : map.get(ch));
        }

        return sb.toString();
    }
}