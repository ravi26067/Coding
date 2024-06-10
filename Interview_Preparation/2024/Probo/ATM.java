class ATM {

    private int[] notes;
    private int[] denominations;

    public ATM() {
        notes = new int[]{0,0,0,0,0};
        denominations = new int[]{20,50,100,200,500};
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i=0;i<banknotesCount.length;i++){
            notes[i]=notes[i]+ banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        Map<Integer,Integer> requiredNotes = new HashMap<>();
        int [] fail = new int[]{-1};
        int []res = new int[]{0,0,0,0,0};
        if (amount%10!=0){
            return fail;
        }
        for(int i=notes.length-1;i>=0;i--){
            int noteValue = denominations[i];
            if(amount>=noteValue){
                int maxNotes = amount/noteValue;
                int availableNotes = notes[i];
                int notesToUse = Math.min(maxNotes,availableNotes);
                requiredNotes.put(noteValue,notesToUse);
                amount-= notesToUse * noteValue;
            }
        }
        if (amount!=0){
            return fail;
        }else{
            for (int i=0;i<denominations.length;i++){
                int noteValue = denominations[i];
                int notesToUse = requiredNotes.getOrDefault(noteValue,0);
                res[i] = notesToUse;
                notes[i] -= notesToUse;
            }
            return res;
        }
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
