/**
 * 游乐设施核心行为接口（对应评估Part2要求）
 * 定义队列管理、乘坐记录管理、设施运行的标准化方法，强制Ride类实现统一行为
 * 设计目的：通过接口实现行为抽象，增强代码扩展性（如后续新增"表演设施"类也可实现此接口）
 */
public interface RideInterface {
    /**
     * 将访客加入游乐设施等待队列（对应评估Part3）
     * @param visitor 待加入队列的访客对象（非null）
     */
    void addVisitorToQueue(Visitor visitor);

    /**
     * 将队首访客移出等待队列（对应评估Part3）
     */
    void removeVisitorFromQueue();

    /**
     * 打印等待队列中的所有访客信息（按加入顺序，对应评估Part3）
     */
    void printQueue();

    /**
     * 将访客添加到游乐设施乘坐历史记录（对应评估Part4A）
     * @param visitor 乘坐后的访客对象（非null）
     */
    void addVisitorToHistory(Visitor visitor);

    /**
     * 检查指定访客是否存在于乘坐历史记录中（对应评估Part4A）
     * @param visitor 待检查的访客对象（非null）
     * @return true=存在，false=不存在
     */
    boolean checkVisitorFromHistory(Visitor visitor);

    /**
     * 获取乘坐历史记录中的访客总数（对应评估Part  4A）
     * @return 历史记录数量（int）
     */
    int numberOfVisitors();

    /**
     * 打印所有乘坐过该设施的访客信息（必须使用Iterator，对应评估Part4A）
     */
    void printRideHistory();

    /**
     * 运行游乐设施一个周期（从队列取访客并加入历史记录，对应评估Part5）
     */
    void runOneCycle();
}