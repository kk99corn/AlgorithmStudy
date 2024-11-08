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
    