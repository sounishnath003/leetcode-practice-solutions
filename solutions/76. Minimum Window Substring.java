                    maxLength = windowLength;
                }
            }
        }
​
        if (start_idx == -1) {
            System.out.println("no window found");
            return "";
        }
​
        String answer = s.substring(start_idx, start_idx + maxLength);
        return answer;
    }
​
    private String minimumWindowSubstring(String s, String p, int start, int end) {
        if (s.length() < p.length())
            return "";
​
        if (s.equals(p))
            return p;
        if (start > end) {
            return s;
        }
​
        String substring = s.substring(start, end + 1);
        if (this.isPatternFound(substring, p)) {
            int substringLength = substring.length();
            String rres = this.minimumWindowSubstring(s, p, start + 1, end);
            if (rres == null)
                return substring;
            return substringLength < rres.length() ? substring : rres;
        }
​
        String way1 = this.minimumWindowSubstring(s, p, start + 1, end);
        String way2 = this.minimumWindowSubstring(s, p, start, end - 1);
        if (way1 == null)
            return way2;
        if (way2 == null)
            return way1;
        return way1.length() < way2.length() ? way1 : way2;
    }
​
    private boolean isPatternFound(String s, String p) {
        Map<Character, Integer> smap = new HashMap<>();
        for (char c : s.toCharArray())
            smap.put(c, smap.getOrDefault(c, 0) + 1);
​
        for (char pc : p.toCharArray()) {
            if (smap.containsKey(pc)) {
                int freq = smap.get(pc);
                if (freq == 0) {
                    smap.remove(pc);
                    return false;
                }
                smap.put(pc, freq - 1);
            } else {
                return false;
            }
        }
​
        return true;
    }
}
