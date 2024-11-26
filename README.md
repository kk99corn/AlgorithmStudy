# AlgorithmStudy
## 알고리즘 스터디
- https://www.inflearn.com/course/자바-알고리즘-문제풀이-코테대비
- https://cote.inflearn.com/contest
- https://docs.oracle.com/en/java/javase/21/docs/api/
- 기간: 2024.11.07 ~
---------------
## Study Notes
- Section 1
    - 01: 문자 찾기
        - 주요 method
            - Character.toUpperCase(char c): char 자료형 대문자 변환
            - String.toCharArray(): String 자료형 char[] 변환
    - 02: 대소문자 변환
        - 주요 method
            - Character.isUpperCase(char c): char 자료형 대문자인지 확인
    - 03: 문장 속 단어
        - 주요 method
            - Scanner.nextLine(): Scanner 단어가 아닌 한 줄로 파라미터 전달받는법
            - String.split(String s): 문자열 기반으로 대상 문자열 String[]로 나누기
    - 04: 단어 뒤집기
        - 주요 method
            - StringBuilder().reverse(): String 문자열 뒤집기
        - 주요 내용
            # Java String vs StringBuilder
            Java에서 문자열 처리에 `String` 클래스 외에도 `StringBuilder`가 존재하는 이유와 그 차이점을 설명합니다.
            ## 1. Introduction to String and StringBuilder
            Java의 `String` 클래스는 불변(immutable) 객체로 설계되어 있습니다. 즉, 한 번 생성된 문자열은 변경될 수 없습니다. 반면, `StringBuilder`는 가변(mutable) 객체로, 기존 문자열을 수정할 수 있도록 설계되었습니다.
            ### Why is `StringBuilder` needed?
            `String` 객체는 불변이므로, 문자열을 수정할 때마다 새로운 객체가 생성됩니다. 이로 인해 문자열을 반복적으로 연결하거나 수정하는 작업에서는 많은 메모리가 소비되고 성능 저하가 발생할 수 있습니다. 이를 보완하기 위해 `StringBuilder`가 도입되었습니다.
            `StringBuilder`는 내부 버퍼를 사용하여 객체를 생성하지 않고도 문자열을 효율적으로 수정할 수 있습니다. 이는 메모리와 성능 측면에서 유리합니다.
            ## 2. Code Example
            ```java
            // Using String (inefficient in loops)
            String str = "Hello";
            for (int i = 0; i < 100; i++) {
                str += " World"; // New String object created each iteration
            }
            // Using StringBuilder (efficient in loops)
            StringBuilder sb = new StringBuilder("Hello");
            for (int i = 0; i < 100; i++) {
                sb.append(" World"); // Appends without creating new object
            }
    - 05: 특정 문자 뒤집기
        - 주요 method
            - Character.isAlphabetic(Char c): Char 자료형 알파벳 체크
    - 06: 중복문자제거
        - 주요 method
            - String.indexOf(String s): 주어진 문자열 s 앞에서부터 (index: 0) 지정한 searchValue가 처음으로 발견되는 위치의 index 반환한다.
    - 07: 회문 문자열
        - 주요 method
            - String.equalsIgnoreCase(String s): 문자열 비교시 대소문자 구분하지 않음
    - 08: 유효한 팰린드롬
        - 주요 method
            - String.replaceAll(String regex, String replace): 정규식으로 문자열 체크 후 교체
- Section 2
    - 08: 등수 구하기
        - 주요 method
            ## Java 배열 내림차순 정렬 예제
            이 저장소는 Java의 Stream API를 이용하여 `int[]` 배열을 내림차순으로 정렬하는 예제를 포함하고 있습니다. 이 접근 방식은 특히 최신 Java 버전(Java 8 이상)에서 기본적인 정렬 작업을 쉽게 처리하는 데 유용합니다.

            ## 코드 개요
            이 코드는 기본 타입 `int[]` 배열을 객체화된 `Stream<Integer>`로 변환하고, 내림차순으로 정렬한 후 다시 기본 타입 배열로 변환하는 과정을 보여줍니다. 아래는 핵심 예제입니다:

            ```java
            import java.util.Arrays;
            import java.util.Collections;

            public class DescendingSortExample {
                public static void main(String[] args) {
                    int[] resultList = {5, 2, 9, 1, 5, 6};
                    
                    int[] sortedResultList = Arrays.stream(resultList)
                            .boxed() // int 값을 Integer 객체로 변환
                            .sorted(Collections.reverseOrder()) // 내림차순으로 정렬
                            .mapToInt(Integer::intValue) // 다시 Integer를 int로 변환
                            .toArray(); // 결과를 int[] 배열로 수집
                    
                    System.out.println(Arrays.toString(sortedResultList));
                }
            }
            ```

            ### 단계별 설명

            - **1단계: `int[]`를 `IntStream`으로 변환**
            ```java
            Arrays.stream(resultList)
            ```
            - `int[]` 배열을 `IntStream`으로 변환하여 스트림 작업을 할 수 있게 만듭니다.

            - **2단계: 원시 타입을 `Stream<Integer>`로 변환**
            ```java
            .boxed()
            ```
            - 각 원소를 원시 타입 `int`에서 `Integer` 객체로 변환합니다. 이는 `Collections.reverseOrder()`로 내림차순 정렬을 하기 위해 필요합니다.

            - **3단계: 내림차순으로 정렬**
            ```java
            .sorted(Collections.reverseOrder())
            ```
            - `Collections.reverseOrder()`를 사용해 스트림을 내림차순으로 정렬합니다.

            - **4단계: 다시 `IntStream`으로 변환**
            ```java
            .mapToInt(Integer::intValue)
            ```
            - 각 `Integer` 객체를 원시 타입 `int`로 변환하여 `IntStream`을 생성합니다.

            - **5단계: 배열로 수집**
            ```java
            .toArray()
            ```
            - 최종적으로 `IntStream`을 `int[]` 배열로 변환합니다.

            ### 주요 메서드

            - **`String.replaceAll(String regex, String replace)`**: 정규식을 사용하여 문자열을 검사한 후 일치하는 부분을 교체합니다.
            - **`Arrays.stream(int[] array)`**: 기본 타입 배열을 스트림으로 변환하여 스트림 작업을 할 수 있게 합니다.
            - **`Stream<T>.sorted(Comparator<? super T> comparator)`**: 스트림의 요소를 주어진 비교자에 따라 정렬합니다.
            - **`IntStream.mapToInt(ToIntFunction<? super T> mapper)`**: 객체 타입 스트림을 원시 타입 스트림으로 변환합니다.

            ### 출력 예시

            입력된 `resultList`가 다음과 같을 경우:
            ```java
            {5, 2, 9, 1, 5, 6}
            ```
            출력 결과는 다음과 같습니다:
            ```java
            [9, 6, 5, 5, 2, 1]
            ```

            ### 장단점

            #### 장점:
            - **가독성**: 코드가 매우 가독성이 높으며, 최신 Java 기능인 Stream API를 사용합니다.
            - **간결성**: 내림차순 정렬을 위해 최소한의 코드로 처리가 가능합니다.

            #### 단점:
            - **박싱 및 언박싱 비용**: `boxed()`와 `mapToInt()` 사용으로 인해 박싱과 언박싱 과정에서 성능 저하가 있을 수 있습니다.
            - **성능 저하**: 대규모 배열에서는 스트림 작업의 성능이 다소 떨어질 수 있습니다.
- Section 3
    - 03: 최대 매출
        - 주요 내용
            ## 슬라이딩 윈도우 알고리즘

            **슬라이딩 윈도우 알고리즘**은 배열이나 리스트 같은 연속된 데이터에서 반복적인 계산을 줄여 시간 복잡도를 최적화하는 데 사용되는 기법입니다. "윈도우"라는 개념을 사용하여 데이터 위를 이동하면서 새로운 요소를 추가하고 이전 요소를 제거하며 필요한 연산을 수행합니다. 주로 연속된 부분 배열이나 부분 문자열과 관련된 문제에 사용됩니다.

            ## 주요 개념

            - **윈도우 크기**: 윈도우 내에 포함되는 요소의 개수로, 문제에 따라 고정되거나 가변적일 수 있습니다.
            - **시작 포인터와 종료 포인터**: `start`와 `end`라는 두 포인터가 윈도우의 경계를 나타냅니다.
            - **슬라이딩 메커니즘**: `end` 포인터를 증가시켜 새로운 요소를 윈도우에 포함하고, 필요할 때 `start` 포인터를 증가시켜 이전 요소를 제외하면서 윈도우를 이동시킵니다.

            ## 슬라이딩 윈도우 유형

            1. **고정 크기 윈도우**: 윈도우의 크기가 일정하며, 연속된 특정 개수의 요소를 다루는 문제에 사용됩니다 (예: `k`개의 연속된 요소의 최대 합 구하기).
            2. **가변 크기 윈도우**: 윈도우 크기가 조건에 따라 달라질 수 있으며, 주로 특정 조건을 만족하는 가장 작은/큰 부분 배열을 찾는 문제에 사용됩니다 (예: 합이 특정 값 이상인 최소 길이 부분 배열 찾기).

            ## 대표적인 활용 예시

            - **최대/최소 합 구하기**: 연속된 부분 배열 중 최대 또는 최소 합을 구하는 문제.
            - **특정 조건을 만족하는 부분 배열 찾기**: 특정 조건을 만족하는 가장 짧거나 긴 부분 배열 찾기.

            ## 예제 코드 (JAVA)

            ```JAVA
            public class SlidingWindow {

                // 주어진 배열에서 k개의 연속된 요소의 최대 합을 구하는 메서드
                public static int maxSumSubarray(int[] arr, int k) {
                    int maxSum = 0;
                    int windowSum = 0;

                    // 첫 번째 윈도우의 합을 계산
                    for (int i = 0; i < k; i++) {
                        windowSum += arr[i];
                    }
                    maxSum = windowSum;

                    // 윈도우를 이동하면서 최대 합 계산
                    for (int i = k; i < arr.length; i++) {
                        windowSum = windowSum - arr[i - k] + arr[i]; // 윈도우의 첫 요소는 빼고, 다음 요소는 더함
                        maxSum = Math.max(maxSum, windowSum);
                    }

                    return maxSum;
                }

                public static void main(String[] args) {
                    int[] arr = {1, 3, 2, 5, 7, 2, 9, 6};
                    int k = 3;
                    System.out.println("최대 합: " + maxSumSubarray(arr, k)); // 결과 출력
                }
            }
    - Section 4
        - 01: 학급 회장(해쉬)
            - 주요 내용
                ## HashMap 주요 메서드 사용법
                `HashMap`은 키-값 쌍을 저장하는 컬렉션으로, 빠른 데이터 검색, 삽입, 삭제를 가능하게 합니다. 이 문서에서는 알고리즘 문제 풀이 시 자주 사용하는 주요 메서드들에 대해 설명합니다.

                ## 주요 메서드 정리

                ### 1. `put(K key, V value)`
                - **설명**: 지정된 키와 값을 맵에 추가합니다. 만약 키가 이미 존재하는 경우, 해당 키에 대한 값을 새로운 값으로 덮어씁니다.
                - **사용 예시**:
                ```java
                HashMap<String, Integer> map = new HashMap<>();
                map.put("apple", 3);
                map.put("banana", 2);
                ```

                ### 2. `get(Object key)`
                - **설명**: 지정된 키에 대응하는 값을 반환합니다. 만약 키가 존재하지 않으면 `null`을 반환합니다.
                - **사용 예시**:
                ```java
                int value = map.get("apple"); // 3 반환
                ```

                ### 3. `containsKey(Object key)`
                - **설명**: 지정된 키가 맵에 존재하는지 여부를 확인합니다. 주로 값의 유무를 빠르게 판단할 때 사용됩니다.
                - **사용 예시**:
                ```java
                if (map.containsKey("apple")) {
                    System.out.println("Key exists");
                }
                ```

                ### 4. `containsValue(Object value)`
                - **설명**: 지정된 값이 맵에 존재하는지 여부를 확인합니다. 특정 값이 맵 내에 존재하는지 검사할 때 사용됩니다.
                - **사용 예시**:
                ```java
                if (map.containsValue(3)) {
                    System.out.println("Value exists");
                }
                ```

                ### 5. `remove(Object key)`
                - **설명**: 지정된 키와 해당 값을 맵에서 제거합니다. 키가 존재하지 않는다면 아무 일도 일어나지 않습니다.
                - **사용 예시**:
                ```java
                map.remove("banana"); // "banana" 키와 그 값 제거
                ```

                ### 6. `size()`
                - **설명**: 맵에 포함된 키-값 쌍의 개수를 반환합니다. 맵이 비어 있는지 확인하거나, 현재 저장된 데이터의 양을 확인할 때 유용합니다.
                - **사용 예시**:
                ```java
                int size = map.size(); // 현재 맵에 있는 항목 수 반환
                ```

                ### 7. `isEmpty()`
                - **설명**: 맵이 비어 있는지 여부를 확인합니다. 요소가 없는 상태인 경우 `true`를 반환합니다.
                - **사용 예시**:
                ```java
                if (map.isEmpty()) {
                    System.out.println("Map is empty");
                }
                ```

                ### 8. `keySet()`
                - **설명**: 맵에 포함된 모든 키를 `Set` 형태로 반환합니다. 이를 통해 반복문을 사용해 모든 키를 순회할 수 있습니다.
                - **사용 예시**:
                ```java
                for (String key : map.keySet()) {
                    System.out.println(key + " : " + map.get(key));
                }
                ```

                ### 9. `values()`
                - **설명**: 맵에 포함된 모든 값을 `Collection` 형태로 반환합니다. 이를 통해 값들만 모아 반복할 수 있습니다.
                - **사용 예시**:
                ```java
                for (Integer value : map.values()) {
                    System.out.println(value);
                }
                ```

                ### 10. `entrySet()`
                - **설명**: 맵에 포함된 모든 키-값 쌍을 `Set` 형태로 반환합니다. 각 키와 값을 동시에 처리하고자 할 때 사용됩니다.
                - **사용 예시**:
                ```java
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }
                ```

                ## 활용 팁
                - `containsKey()`는 특정 키가 존재하는지 확인하여 값을 가져올 때 `null` 반환을 방지하는 데 유용합니다.
                - `entrySet()`을 사용하면 키와 값을 동시에 효율적으로 접근할 수 있어 맵을 순회하는 과정에서 유리합니다.

                ## 예제 코드
                다음은 `HashMap`을 사용하여 특정 작업을 수행하는 간단한 예제입니다:

                ```java
                public class HashMapExample {
                    public static void main(String[] args) {
                        HashMap<String, Integer> map = new HashMap<>();
                        map.put("apple", 3);
                        map.put("banana", 2);
                        map.put("orange", 5);

                        if (map.containsKey("apple")) {
                            System.out.println("Apple count: " + map.get("apple"));
                        }

                        map.remove("banana");
                        System.out.println("Map size after removal: " + map.size());

                        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                            System.out.println(entry.getKey() + " : " + entry.getValue());
                        }
                    }
                }
                ```

                ## 결론
                `HashMap`은 키-값 쌍의 데이터를 효율적으로 관리할 수 있는 강력한 자료구조입니다. 위에 설명한 주요 메서드들을 활용하면 대부분의 알고리즘 문제에서 간단하고 빠르게 데이터를 처리할 수 있습니다. 각 메서드의 특성을 잘 이해하고 적절히 활용해 보세요!
    - Section 6
        - 01: 선택정렬
            - 주요 내용
                ## Selection Sort

                Selection Sort는 정렬 알고리즘 중 하나로, 리스트를 반복적으로 순회하며 가장 작은(혹은 큰) 요소를 찾아 리스트의 앞부분부터 정렬하는 방식으로 동작합니다.

                ## 특징
                - **시간 복잡도**: O(n²)
                - **공간 복잡도**: O(1) (제자리 정렬)
                - **장점**: 구현이 간단하고, 비교 횟수가 일정함.
                - **단점**: 데이터가 많을수록 비효율적.

                ## 작동 원리
                1. 주어진 리스트에서 가장 작은 값을 찾는다.
                2. 해당 값을 리스트의 첫 번째 요소와 교환한다.
                3. 두 번째 요소부터 다시 반복한다.
                4. 리스트가 모두 정렬될 때까지 위 과정을 반복한다.

                ## 구현 예제 (Java)

                아래는 Java로 구현한 Selection Sort 코드입니다:

                ```java
                public class SelectionSort {

                    public static void selectionSort(int[] arr) {
                        int n = arr.length;

                        // 배열을 순회하며 정렬
                        for (int i = 0; i < n - 1; i++) {
                            // 현재 범위에서 가장 작은 값의 인덱스를 찾음
                            int minIndex = i;
                            for (int j = i + 1; j < n; j++) {
                                if (arr[j] < arr[minIndex]) {
                                    minIndex = j;
                                }
                            }

                            // 가장 작은 값을 현재 위치와 교환
                            int temp = arr[minIndex];
                            arr[minIndex] = arr[i];
                            arr[i] = temp;
                        }
                    }

                    public static void main(String[] args) {
                        int[] arr = {64, 25, 12, 22, 11};

                        System.out.println("Before Sorting:");
                        for (int num : arr) {
                            System.out.print(num + " ");
                        }

                        selectionSort(arr);

                        System.out.println("\n\nAfter Sorting:");
                        for (int num : arr) {
                            System.out.print(num + " ");
                        }
                    }
                }
        - 02: 버블정렬
            - 주요 내용
                ## Bubble Sort

                Bubble Sort는 정렬 알고리즘 중 하나로, 인접한 두 요소를 비교하여 필요한 경우 위치를 교환하며 정렬을 수행합니다. 작은 값을 위로 "버블"처럼 올리는 과정에서 이름이 유래되었습니다.

                ## 특징
                - **시간 복잡도**: O(n²) (최악 및 평균), O(n) (최선, 이미 정렬된 경우)
                - **공간 복잡도**: O(1) (제자리 정렬)
                - **장점**: 구현이 간단하고 이해하기 쉬움.
                - **단점**: 데이터 크기가 클수록 비효율적이며, 선택 정렬보다 비교 횟수가 많음.

                ## 작동 원리
                1. 배열을 순회하며 인접한 두 요소를 비교한다.
                2. 두 요소의 크기가 잘못된 순서라면 교환한다.
                3. 배열의 끝까지 반복한 후, 가장 큰 값이 정렬된다.
                4. 나머지 요소들에 대해 이 과정을 반복한다.

                ## 구현 예제 (Java)

                아래는 Java로 구현한 Bubble Sort 코드입니다:

                ```java
                public class BubbleSort {

                    public static void bubbleSort(int[] arr) {
                        int n = arr.length;

                        // 배열을 순회하며 정렬
                        for (int i = 0; i < n - 1; i++) {
                            boolean swapped = false;

                            // 인접한 두 요소를 비교 및 교환
                            for (int j = 0; j < n - 1 - i; j++) {
                                if (arr[j] > arr[j + 1]) {
                                    // 요소 교환
                                    int temp = arr[j];
                                    arr[j] = arr[j + 1];
                                    arr[j + 1] = temp;
                                    swapped = true;
                                }
                            }

                            // 교환이 발생하지 않았으면 정렬 완료
                            if (!swapped) {
                                break;
                            }
                        }
                    }

                    public static void main(String[] args) {
                        int[] arr = {64, 34, 25, 12, 22, 11, 90};

                        System.out.println("Before Sorting:");
                        for (int num : arr) {
                            System.out.print(num + " ");
                        }

                        bubbleSort(arr);

                        System.out.println("\n\nAfter Sorting:");
                        for (int num : arr) {
                            System.out.print(num + " ");
                        }
                    }
                }
        - 03: 삽입정렬
            - 주요 내용
                ## Insertion Sort

                Insertion Sort는 정렬 알고리즘 중 하나로, 배열을 순차적으로 탐색하면서 현재 요소를 이미 정렬된 부분에 삽입하여 정렬을 수행합니다. 카드를 정렬하는 방식과 유사합니다.

                ## 특징
                - **시간 복잡도**: O(n²) (최악 및 평균), O(n) (최선, 이미 정렬된 경우)
                - **공간 복잡도**: O(1) (제자리 정렬)
                - **장점**: 데이터가 거의 정렬된 경우 매우 효율적.
                - **단점**: 데이터 크기가 클수록 비효율적.

                ## 작동 원리
                1. 배열의 두 번째 요소부터 시작하여 이전 요소들과 비교한다.
                2. 적절한 위치에 현재 요소를 삽입한다.
                3. 배열의 끝까지 이 과정을 반복한다.

                ## 구현 예제 (Java)

                아래는 Java로 구현한 Insertion Sort 코드입니다:

                ```java
                public class InsertionSort {

                    public static void insertionSort(int[] arr) {
                        int n = arr.length;

                        // 배열을 순회하며 정렬
                        for (int i = 1; i < n; i++) {
                            int key = arr[i]; // 현재 삽입할 값
                            int j = i - 1;

                            // 현재 값보다 큰 값들을 한 칸씩 뒤로 이동
                            while (j >= 0 && arr[j] > key) {
                                arr[j + 1] = arr[j

                


            
