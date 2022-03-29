# -*- coding: UTF-8 -*-

class Solution:
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        stack = list()
        op_set = set(["+", "-", "*", "/"])
        for item in tokens:
            if item not in op_set:
                stack.append(int(item))
            else:
                first_num, second_num = stack.pop(), stack.pop()
                tmp = int(eval(f'{second_num} {item} {first_num}'))
                stack.append(tmp)
        return int(stack.pop())