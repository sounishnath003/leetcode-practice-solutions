import java.util.ArrayList;
import java.util.List;

public class MaxiumofAllSubarray {
    private class ElementPosition {
        int value;
        int index;

        public ElementPosition(int index, int value) {
            this.value = value;
            this.index = index;
        }

        @Override
        public String toString() {
            return "ElementPosition{" +
                    "value=" + value +
                    ", index=" + index +
                    '}';
        }
    }
    public List<Integer> getMaximumOfWindowK(int[] arr, int k) {
        int startIndex = 0;
        int endIndex = 0;

        ElementPosition firstMaxElement = new ElementPosition(-1, Integer.MIN_VALUE);
        ElementPosition secondMaxElement = new ElementPosition(-1, Integer.MIN_VALUE);

        List<Integer> result = new ArrayList<>();

        while (endIndex < arr.length) {
            // calculation
            ElementPosition[] elementPositions = determineFirstMaxAndSecondMax(firstMaxElement, secondMaxElement, arr, endIndex);
            firstMaxElement = elementPositions[0];
            secondMaxElement = elementPositions[1];

            int windowSize = (endIndex - startIndex + 1);
            if (windowSize == k) {
                System.out.println("firstMax: " + firstMaxElement);
                System.out.println("secondMax: " + secondMaxElement);
                System.out.println("========");

                // get answer
                result.add(firstMaxElement.value);
                // slide the window
                startIndex++;
                // if startIndex bounds then update firstmax and secondmax
                ElementPosition[] elementPositions1 = updateFirstMaxAndSecondMax(firstMaxElement, secondMaxElement, startIndex);
                firstMaxElement = elementPositions1[0];
                secondMaxElement = elementPositions[1];
            }

            endIndex++;
        }

        return result;
    }

    private ElementPosition[] updateFirstMaxAndSecondMax(ElementPosition firstMaxElement, ElementPosition secondMaxElement, int currIndex) {
        if (currIndex > firstMaxElement.index) {
            firstMaxElement = secondMaxElement;
        }

        return new ElementPosition[]{firstMaxElement, secondMaxElement};
    }

    private ElementPosition[] determineFirstMaxAndSecondMax(ElementPosition firstMaxElement, ElementPosition secondMaxElement, int[] arr, int endIndex) {
        int element = arr[endIndex];

        if (element > firstMaxElement.value) {
            secondMaxElement = firstMaxElement;
            firstMaxElement = new ElementPosition(endIndex, element);
        } else  if (element > secondMaxElement.value) {
            // just update second max
            secondMaxElement = new ElementPosition(endIndex, element);
        }

        return new ElementPosition[]{firstMaxElement, secondMaxElement};
    }
}


class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        MaxiumofAllSubarray maxiumofAllSubarray = new MaxiumofAllSubarray();
        List<Integer> ans = maxiumofAllSubarray.getMaximumOfWindowK(arr, k);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
