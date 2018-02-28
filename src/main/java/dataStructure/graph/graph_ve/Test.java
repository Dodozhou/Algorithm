package dataStructure.graph.graph_ve;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph();
        System.out.println("该图的邻接表为：");
        outputGraph(graph);
    }

    /**
     * 输出图的邻接表的方法。
     * @param graph 要输出的图
     */
    public static void outputGraph(Graph graph){
        for (int i=0;i<graph.verNum;i++){
            Vertex vertex = graph.verArray[i];
            System.out.print(vertex.verName);

            Edge current = vertex.edgeLink;
            while (current != null){
                System.out.print("--"+current.weight+"-->"+current.tailName);
                current = current.broEdge;
            }
            System.out.println();
        }
    }
}
/* 测试结果：
请输入节点个数和边的个数：
4 5
请依次输入节点的名称:
V0 V1 V2 V3
请按‘头节点 权值 尾节点 回车’的形式依次输入边的信息
V0 5 V3
V1 3 V0
V2 9 V0
V1 6 V2
V2 7 V1
该图的邻接表为：
V0--5-->V3
V1--6-->V2--3-->V0
V2--7-->V1--9-->V0
V3
 */
