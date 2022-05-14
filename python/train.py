#def func(heights):
#    size = len(heights)
#    l_max = [0] * size
#    r_max = [0] * size
#    result = 0
#    # 初始化
#    l_max[0] = heights[0]
#    for i in range(1, size):
#        l_max[i] = max(l_max[i-1], heights[i])
#    r_max[size-1] = heights[size-1]
#    for i in range(size-2, -1, -1):
#        r_max[i] = max(r_max[i+1], heights[i])
#    # 遍历
#    for i in range(0, size):
#        tmp = min(l_max[i], r_max[i])
#        if tmp > heights[i]:
#            result += tmp - heights[i]
#    return result
#
#print(func([0,1,0,2,1,0,1,3,2,1,2,1]))

def func(x1,y1,x2,y2,x3,y3,x4,y4):
    '''
    2个方框的交叉比
    '''
    min_x = max(x1, x3)
    min_y = max(y1, y3)
    max_x = min(x2, x4)
    max_y = min(y2, y4)

    join_area = (max_y-min_y) * (max_x-min_x)
    area1 = (y2-y1) * (x2-x1)
    area2 = (y4-y3) * (x4-x3)
    rtn = float(join_area) / (area1 + area2 - join_area)
    return 0 if join_area<=0 else rtn