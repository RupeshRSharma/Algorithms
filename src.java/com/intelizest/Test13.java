package com.intelizest;

class Test13 {
	
	
	
    public static int[] solution(int N, int[] A) {
        int max = 0, allMax = 0;
        int[] res = new int[N];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                allMax = max;
            } else {
                res[A[i]-1] = Math.max(allMax, res[A[i]-1]) + 1;
                max = Math.max(max, res[A[i]-1]);
            }
        }
        for (int i = 0; i < N; i++) {
            res[i] = Math.max(res[i], allMax);
        }
        return res;
    }
    
    
   public static void main(String[] args) {
	   
   }
}
