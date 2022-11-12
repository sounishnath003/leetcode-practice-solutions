class Solution {
    public int numUniqueEmails(String[] emails) {
        int totalUniqEmails = 0;
​
        HashSet<String> set = new HashSet<>();
​
        for (String email : emails) {
            email = normalizeTheEmailPattern(email);
            set.add(email);
        }
​
        totalUniqEmails = set.size();
        return totalUniqEmails;
    }
​
    private String normalizeTheEmailPattern(String email) {
        // TODO Auto-generated method stub
        StringBuilder normalizedEmail = new StringBuilder();
        boolean ignoreChars = false;
        boolean domainPart = false;
​
        for (char x : email.toCharArray()) {
            if (x == '@') {
                ignoreChars = false;
                domainPart = true;
            }
​
            if (domainPart) {
                normalizedEmail.append(x);
                continue;
            }
​
            if (x == '.')
                continue;
            if (x == '+') {
                ignoreChars = true;
                continue;
            }
​
            if (ignoreChars == true)
                continue;
​
            normalizedEmail.append(x);
        }
​
        return normalizedEmail.toString();
    }
}
