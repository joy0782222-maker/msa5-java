package org.example.e05array;

import java.util.Arrays;

public class E05Array {
    public static void main(String[] args) {
        int[] arrI = new int[3];
        arrI[0] = 1;
        arrI[1] = 2;
        arrI[2] = 3;

        int[] arr2 = {1, 2, 3};
        System.out.println(Arrays.toString(arrI));

//        배열의 복사
        int[] originArr = {1, 5, 9};
        int[] copyArr = originArr;
        copyArr[0] = 99;

//        System.arraycopy() 깊은복사
        int[] originArrSystem = {1, 2, 3};
        int[] copyArrSystem = new int[originArrSystem.length * 2];
        System.arraycopy(
                originArrSystem,
                0,
                copyArrSystem,
                0,
                originArrSystem.length
        );
        copyArrSystem[0] = 99;

//        Arrays.copyof() 깊은 복사
        int[] originArrArrays = {1, 2, 3};
//        int[] copyArrArrays = new int[originArrArrays.length * 2];
//        copyArrArrays = Arrays.copyOf(originArrArrays, originArrArrays.length);
        int[] copyArrArrays = Arrays.copyOf(originArrArrays, originArrArrays.length);
        copyArrArrays[0] = 99;

//        구현해보기
        int[] originFor = {1,2,3};
        int[] copyFor = new int[originFor.length * 2];

//        for (int i = 0; i < originFor.length; i++) {
//            copyFor[i] = originFor[i];
//        }

//        향상된 for
        int idx = 0;
        for(int val : originFor) {
            copyFor[idx] = val;
            idx++;
        }

//        다차원 배열
        int[][] multiArr = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        };
        System.out.println(multiArr[1][1]);

//        배열 API
        int[] arr3 = {1,2,3};
        int[] arr4 = {1,2,3};
//        배열 길이
        System.out.println(arr3.length);

//        Arrays.equals(arr1, arr2) 배열 같은지 비교
        System.out.println(Arrays.equals(arr3, arr4));

//        Arrays.deepEquals(arr1, arr2) 다차원 배열 비교
        int[][] deepArr1 = {{1,2,3},{4,5,6}};
        int[][] deepArr2 = {{1,2,3},{4,5,7}};
        System.out.println(Arrays.deepEquals(deepArr1, deepArr2));

//        Arrays.sort(arr) 배열 정렬 (원본 수정 주의)
        int[] sortArr = {43, 6, 7, 8, 4, 34, 2};
        Arrays.sort(sortArr);
        System.out.println(Arrays.toString(sortArr));

    }
}
