public class SortAlgorithms {
    public static void main()
     {
        int[] array = new int[15000];
        
        SortAlgorithms.initialize(array);
        double timeStartQuick1 = System.currentTimeMillis();
        SortAlgorithms.quick(array, 0, (array.length-1)); 
        System.out.println((("The time for quick sort with 100000 non sorted numbers was: " + (System.currentTimeMillis() - timeStartQuick1)/1000.0)));
        System.out.println(SortAlgorithms.check(array));
        
        
        SortAlgorithms.initialize(array);
        SortAlgorithms.sort(array);
        double timeStartQuick2 = System.currentTimeMillis();
        SortAlgorithms.quick(array, 0, (array.length-1)); 
        System.out.println((("The time for quick sort with 100000 sorted numbers was: " + (System.currentTimeMillis() - timeStartQuick2)/1000.0)));
        System.out.println(SortAlgorithms.check(array));
        
        
        SortAlgorithms.initialize(array);
        SortAlgorithms.sort(array);
        SortAlgorithms.initializeBackwards(array);
        double timeStartQuick3 = System.currentTimeMillis();
        SortAlgorithms.quick(array, 0, (array.length-1)); 
        System.out.println((("The time for quick sort with 100000 backwards sorted numbers was: " + (System.currentTimeMillis() - timeStartQuick3)/1000.0)));
         System.out.println(SortAlgorithms.check(array));
        
        
        SortAlgorithms.initialize(array);
        double timeStartSelection1 = System.currentTimeMillis();
        SortAlgorithms.selection(array);
        System.out.println((("The time for selection sort with 100000 non sorted numbers was: " + (System.currentTimeMillis() - timeStartSelection1)/1000.0)));
        System.out.println(SortAlgorithms.check(array));
        
        SortAlgorithms.initialize(array);
        SortAlgorithms.sort(array);
        double timeStartSelection2 = System.currentTimeMillis();
        SortAlgorithms.selection(array);
        System.out.println((("The time for selection sort with 100000 sorted numbers was: " + (System.currentTimeMillis() - timeStartSelection2)/1000.0)));
        System.out.println(SortAlgorithms.check(array));
        
        
        SortAlgorithms.initialize(array);
        SortAlgorithms.sort(array);
        SortAlgorithms.initializeBackwards(array);
        double timeStartSelection3 = System.currentTimeMillis();
        SortAlgorithms.selection(array);
        System.out.println((("The time for selection sort with 100000 backwards sorted numbers was: " + (System.currentTimeMillis() - timeStartSelection3)/1000.0)));
        System.out.println(SortAlgorithms.check(array));
        
        
        
        
        SortAlgorithms.initialize(array);
        double timeStartMerge1 = System.currentTimeMillis();
        int[] sortedArray1 = SortAlgorithms.mergeSort(array);
        System.out.println((("The time for merge sort with 100000 non sorted numbers was: " + (System.currentTimeMillis() - timeStartMerge1)/1000.0)));
        System.out.println(SortAlgorithms.check(sortedArray1));
        
        
        SortAlgorithms.initialize(array);
        SortAlgorithms.sort(array);
        double timeStartMerge2 = System.currentTimeMillis();
        SortAlgorithms.mergeSort(array);
        System.out.println((("The time for merge sort with 100000 sorted numbers was: " + (System.currentTimeMillis() - timeStartMerge2)/1000.0)));
        System.out.println(SortAlgorithms.check(array));
        
        SortAlgorithms.initialize(array);
        SortAlgorithms.sort(array);
        SortAlgorithms.initializeBackwards(array);
        double timeStartMerge3 = System.currentTimeMillis();
        int[] sortedArray2 = SortAlgorithms.mergeSort(array);
        System.out.println((("The time for merge sort with 100000 backwards sorted numbers was: " + (System.currentTimeMillis() - timeStartMerge3)/1000.0)));
        System.out.println(SortAlgorithms.check(sortedArray2));        
        
        
        SortAlgorithms.initialize(array);
        double timeStartInsertion1 = System.currentTimeMillis();
        SortAlgorithms.insertion(array);
        System.out.println((("The time for insertion sort with 100000 non sorted numbers was: " + (System.currentTimeMillis() - timeStartInsertion1)/1000.0)));
         System.out.println(SortAlgorithms.check(array));
        
        SortAlgorithms.initialize(array);
        SortAlgorithms.sort(array);
        double timeStartInsertion2 = System.currentTimeMillis();
        SortAlgorithms.insertion(array);
        System.out.println((("The time for insertion sort with 100000 sorted numbers was: " + (System.currentTimeMillis() - timeStartInsertion2)/1000.0)));
        System.out.println(SortAlgorithms.check(array));
        
        SortAlgorithms.initialize(array);
        SortAlgorithms.sort(array);
        SortAlgorithms.initializeBackwards(array);
        double timeStartInsertion3 = System.currentTimeMillis();
        SortAlgorithms.insertion(array);
        System.out.println((("The time for insertion sort with 100000 backwards sorted numbers was: " + (System.currentTimeMillis() - timeStartInsertion3)/1000.0)));
        System.out.println(SortAlgorithms.check(array));
        
    }
    public static int[] mergeSort(int[] oldArray)
    {
        if (oldArray.length == 1)
        {
            return oldArray;
        }
        int[] arr1;
        int[] arr2;
        int midPoint1 = (oldArray.length / 2);
        arr1 = new int[midPoint1];
        arr2 = new int[oldArray.length-midPoint1];
        for (int i = 0; i < oldArray.length; i++)
        {
             if(i<midPoint1){
                 arr1[i] = oldArray[i];
             }
             else{
                 arr2[i-midPoint1] = oldArray[i];
             }       
        }
        arr1 = SortAlgorithms.mergeSort(arr1);
        arr2 = SortAlgorithms.mergeSort(arr2);
        int[] arrf = new int[oldArray.length];
        int n = 0;
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length)
        {
            if (arr1[i] < arr2[j])
            {
                 arrf[n] = arr1[i];
                 i++;
            }
            else
            {
                arrf[n] = arr2[j];
                j++;
            }
            n++;
        }
        if (i == arr1.length)
        {
            while (j < arr2.length)
            {
                arrf[n] = arr2[j];
                j++;
                n++;
            }
        }
        else 
        {
            while (i < arr1.length)
            {
                arrf[n] = arr1[i];
                i++;
                n++;
            }
        }
        return arrf;
    }
    public static void selection(int[] array){
        for (int i = 0; i < array.length; i++) {
            
            int lowest = array[i];
            int indexLowest = i;
            for (int z = i + 1; z < array.length; z++) {
                if (array[z] < lowest)
                {
                    indexLowest = z;
                    lowest = array[z];
                }
            }
            int temp = array[i];
            array[i] = lowest;
            array[indexLowest] = temp;
       }
     }
    public static void insertion(int[] array){
        for (int i = 1; i < array.length; i++) { 
           int z = (i-1);
           while (z >= 0 && array[z+1] < array[z]) {
               int temp = array[z+1];
               int temp1 = array[z];
               array[z] = temp;
               array[z+1] = temp1;
               z--;
           }   
       }  
    }
    public static int[] quick(int[] array, int start, int end)
    {
        if(start == end)
        {
            return array;
        }
        int i = start - 1;
        int j = end +1;
        int pivot = array[start];
        while (i < j)
        {
            i++;
            j--;
            while (array[i] < pivot)
            {
                i++;
            }
            while (array[j] > pivot)
            {
                j--;
            }
            if (i<j)
            {
               int temp = array[i];
               array[i] = array[j];
               array[j] = temp;
            }
        }
        SortAlgorithms.quick(array, start, j);
        SortAlgorithms.quick(array, j+1, end);
        return array;
    }
    public static void initialize(int[] array) {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = (int) (Math.random()*1001);
        }
    }
    public static void initializeBackwards(int[] array) {
        for (int i = 0; i < array.length; i++)
        {
            array[array.length-1-i] = i;
        }
    }
    public static void sort(int[] array)
    {
        for (int i = 1; i < array.length; i++) { 
           int z = (i-1);
           while (z >= 0 && array[z+1] < array[z]) {
               int temp = array[z+1];
               int temp1 = array[z];
               array[z] = temp;
               array[z+1] = temp1;
               z--;
           }   
       }  
    }
    public static String check(int[] array)
    {
        for(int i = 1; i < array.length; i++)
        {
            if (array[i] < array[i-1])
            {
                return "not sorted";
            }
        }
        return "sorted";
    }
    
    
    
}