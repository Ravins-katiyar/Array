class Solution:
    def reverseParentheses(self, s: str) -> str:
        stack = []
        
        for char in s:
            if char == ')':
                # Pop characters until finding '('
                substring = []
                while stack and stack[-1] != '(':
                    substring.append(stack.pop())
                # Remove the '(' from the stack
                stack.pop()
                # Push the reversed substring back onto the stack
                stack.extend(substring)
            else:
                # Push current character to the stack
                stack.append(char)
        
        # Join the characters to form the final result
        return ''.join(stack)
