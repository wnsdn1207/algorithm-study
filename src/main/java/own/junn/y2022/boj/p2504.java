package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 2504 - 괄호의 값
 */
public class p2504 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        char[] chars = reader.readLine().toCharArray();
        if (chars.length % 2 == 1) {
            System.out.println(0);
            return;
        }
        System.out.println(calculateParenthesis(chars));

        reader.close();
    }

    /**
     * 괄호 계산 함수
     *
     * tmp 변수에 값을 할당하고 해당 값에 곱하거나 나누는 방식으로 연산을 진행
     *
     * 1. (, [와 같은 여는 괄호는 tmp 값에 해당하는 값을 곱하여준다.
     * 2. ), ]와 같은 닫는 괄호는 tmp 값에 해당하는 값을 나누어준다.
     * 3. 이 때, 직전 괄호가 닫는 괄호와 매칭되는 여는 괄호일 시, answer 변수에 tmp 변수를 더해준다.
     *
     * @param parenthesis 괄호 Character Array
     * @return 계산된 값, [(): 2, []: 3, (x): x*2, [x]: x*3]
     */
    static int calculateParenthesis(char[] parenthesis) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        int tmp = 1;
        for (int i=0; i<parenthesis.length; i++) {
            if (parenthesis[i] == '(') {
                stack.push(parenthesis[i]);
                tmp *= 2;
            } else if (parenthesis[i] == '[') {
                stack.push(parenthesis[i]);
                tmp *= 3;
            } else if (parenthesis[i] == ')') {
                if (stack.size() > 0 && stack.peek() == '(') {
                    stack.pop();
                    if (parenthesis[i-1] == '(') {
                        answer += tmp;
                    }
                    tmp /= 2;
                } else {
                    return 0;
                }
            } else if (parenthesis[i] == ']') {
                if (stack.size() > 0 && stack.peek() == '[') {
                    stack.pop();
                    if (parenthesis[i-1] == '[') {
                        answer += tmp;
                    }
                    tmp /= 3;
                } else {
                    return 0;
                }
            }
        }

        return answer;
    }
}

