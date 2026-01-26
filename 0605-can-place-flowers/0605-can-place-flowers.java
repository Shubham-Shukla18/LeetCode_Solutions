class Solution {
    //my solution
    // public boolean canPlaceFlowers(int[] flowerbed, int n) {
    //     boolean canFlower = false;
        
    //     // to handle n=0 situation
    //     if (n==0) {
    //         return true;
    //     }

    //     int flowerbedLen = flowerbed.length;
    //     // to handle array of length 1 and 2 respectively
    //     if(flowerbedLen==1 && n==1) {
    //         if(flowerbed[0]==0) {
    //             return true;
    //         }
    //         else {
    //             return canFlower;
    //         }
    //     }

    //     if(flowerbedLen==2 && n==1) {
    //         if(flowerbed[0]==1 || flowerbed[1]==1) {
    //             return canFlower;
    //         }
    //         else {
    //             return true;
    //         }
    //     }
        
    //     //to handle array of length > 2.
    //     if(flowerbedLen > 2 && n>0) {
            
    //         for(int i=0; i<flowerbedLen; i++) {
    //             int prev = i-1;
    //             int curr = i;
    //             int next = i+1;

    //             // to handle frist index 
    //             if(i==0) {
    //                 if(flowerbed[curr]==0 && flowerbed[next]==0 && n>0) {
    //                     flowerbed[curr] = 1;
    //                     n--;
    //                 }
    //             }

    //             // to handle between 1 to flowerbedLen-2 index
    //             if(i>0 && i<flowerbedLen-1) {
    //                 if(flowerbed[prev]==0 && flowerbed[curr]==0 && flowerbed[next]==0 && n>0) {
    //                     flowerbed[curr] = 1;
    //                     n--;
    //                 }
    //             }

    //             // to handle last index
    //             if(i==(flowerbedLen-1)){
    //                 if(flowerbed[prev]==0 && flowerbed[curr]==0 && n>0){
    //                     flowerbed[curr] = 1;
    //                     n--;
    //                 }
    //             }

    //         }

    //         if(n==0) {
    //             return true;
    //         }
    //     }

    //     return canFlower;
    // }


    public boolean canPlaceFlowers(int[] f, int n){
        for(int i=0;i<f.length;i=i+2){
            if(f[i]==0){
                if(i==f.length-1||f[i]==f[i+1]){
                    n--;
                }
                else{
                    i++;
                }
            }
        }
        return n<=0;
        
    }
}