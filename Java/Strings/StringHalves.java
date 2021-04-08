class Solution {
    public boolean halvesAreAlike(String s) {
        int len =s.length();
        if(countV(s.substring(0,len/2))==countV(s.substring(len/2,len)))
            return true;
        else
            return false;
        
    }
    public int countV(String s){
        char c;
        int cnt = 0;
        for(int i = 0 ; i<s.length() ; i++ ){
            c = s.charAt(i);
            if(c=='a' || c=='A' || c=='e'|| c=='E'|| c=='i'|| c=='I'|| c=='o'|| c=='O'|| c=='U'|| c=='u')
                cnt++;
        }
        return cnt;
    }
}
