package dataStructure.graph.graph_ve;

import javax.naming.ldap.StartTlsRequest;
import java.util.Scanner;

/**
 * 图类，在构造方法中完成图的构造
 */
public class Graph {
    /**
     * 图的节点个数
     */
    int verNum;
    /**
     * 图的边的条数
     */
    int edgeNum;
    /**
     * 图的邻接表中存储节点的数组
     */
    Vertex[] verArray;

    /**
     * Graph类的构造方法，依次读取节点、边等信息，完成图的构建。
     */
    public Graph() {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入节点个数和边的个数：");
        verNum = scan.nextInt();
        edgeNum = scan.nextInt();
        verArray = new Vertex[verNum];

        System.out.println("请依次输入节点的名称:");
        for (int i=0;i<verNum;i++){
            Vertex vertex = new Vertex();
            vertex.verName = scan.next();
            vertex.edgeLink = null;
            verArray[i] = vertex;
        }

        System.out.println("请按‘头节点 权值 尾节点 回车’的形式依次输入边的信息");
        for (int i=0;i<edgeNum;i++){
            String preName = scan.next();
            int weight = scan.nextInt();
            String folName = scan.next();

            Vertex preV = getVertex(preName);
            Vertex folV = getVertex(folName);
            if (preV == null || folV == null){
                System.out.println("输入错误，输入了不存在的顶点！请重新输入");
                i--;
                continue;
            }

            Edge edge = new Edge();
            edge.tailName = folName;
            edge.weight = weight;

            //将边加入到节点的链表中去
            edge.broEdge = preV.edgeLink;
            preV.edgeLink = edge;
        }
    }

    /**
     * 根据节点名称获取该节点
     * @param verName 节点的名称
     * @return 节点或null
     */
    public Vertex getVertex(String verName){
        for (int i=0;i<verNum;i++){
            if (verArray[i].verName.equals(verName))
                return verArray[i];
        }
        return null;
    }
}
