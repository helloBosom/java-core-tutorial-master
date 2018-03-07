package com.logic.socket;

import org.junit.Test;

public class test5 {


    public String compress2(String str) {
        if (str == null) {
            return null;
        } else {
            StringBuilder sBuilder = new StringBuilder();
            char currChar = str.charAt(0);
            int counter = 1;

            for (int i = 1; i < str.length(); ++i) {
                if (str.charAt(i) == currChar) {
                    ++counter;
                } else {
                    sBuilder.append(currChar).append(counter);
                    currChar = str.charAt(i);
                    counter = 1;
                }
            }

            sBuilder.append(currChar).append(counter);
            return sBuilder.length() < str.length() ? sBuilder.toString() : str;
        }
    }

    public char[] compress(char[] chars) {
        if (chars == null) {
            return chars;
        } else {
            int newLen = this.calculateLen(chars);
            if (newLen > chars.length) {
                return chars;
            } else {
                char[] compressedChars = new char[newLen];
                int newIdx = 0;
                char currChar = chars[0];
                int counter = 1;

                for (int i = 1; i < chars.length; ++i) {
                    if (chars[i] == currChar) {
                        ++counter;
                    } else {
                        compressedChars[newIdx++] = currChar;
                        String str = String.valueOf(counter);

                        for (int j = 0; j < str.length(); ++j) {
                            compressedChars[newIdx++] = str.charAt(j);
                        }

                        currChar = chars[i];
                        counter = 1;
                    }
                }

                compressedChars[newIdx++] = currChar;
                String str = String.valueOf(counter);

                for (int j = 0; j < str.length(); ++j) {
                    compressedChars[newIdx++] = str.charAt(j);
                }

                return compressedChars;
            }
        }
    }

    private int calculateLen(char[] chars) {
        int total = 0;
        char currChar = chars[0];
        int counter = 1;

        for (int i = 1; i < chars.length; ++i) {
            if (chars[i] == currChar) {
                ++counter;
            } else {
                ++total;
                total += String.valueOf(counter).length();
                currChar = chars[i];
                counter = 1;
            }
        }

        ++total;
        total += String.valueOf(counter).length();
        return total;
    }

    @Test
    public void test() {
        String[] strs = new String[]{"aaabbbcccddd", "abcdefghijklmn"};
        String[] var2 = strs;
        int var3 = strs.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            String str = var2[var4];
            System.out.println(str);
            char[] result = this.compress(str.toCharArray());
            System.out.println(new String(result));
            System.out.println(this.compress2(str));
            System.out.println();
        }

    }
}
