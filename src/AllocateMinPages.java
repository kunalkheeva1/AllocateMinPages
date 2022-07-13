public class AllocateMinPages {

    static boolean check(int[] arr,int n, int m, int mid){
        int count = 0;
        int pages = 0;
        for(int i= 0; i<n; i++){
            if(arr[i] + pages <= mid){
                pages += arr[i];
            }else{
                count ++;
                pages = arr[i];
            }
        }
        if(count<=m){
            return true;
        }else{
            return false;
        }
    }



    public static int allocateMinPages(int [] arr, int n, int m){
        int low = 0;
        int high = 0;
        for(int i=0; i<n; i++){
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        int ans = -1;
        while(low<=high){
            int mid = (low+ high)/2;
            if((check(arr, n, m, mid))){
                high = mid-1;
                ans = mid;
            }else{
                low = mid-1;
            }
        }return ans;


    }






    public static void main(String[] args) {

    }
}
