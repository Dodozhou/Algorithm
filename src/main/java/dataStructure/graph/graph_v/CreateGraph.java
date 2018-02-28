package dataStructure.graph.graph_v;

import java.util.Scanner;

/**
 * 邻接表创建图的方式1，这种方式不能存储边的权值
 */
public class CreateGraph {
    /**
     * 根据顶点名字查找并返回特定的顶点
     * @param graph 图
     * @param name 要查找顶点的名字
     * @return 符合的顶点或null
     */
    public Vertex getVertex(Graph graph,String name){
        for (int i=0;i<graph.verNum;i++){
            if (graph.vertexArray[i].name.equals(name))
                return graph.vertexArray[i];
        }
        return null;
    }

   public void initGraph(Graph graph){
       Scanner scan = new Scanner(System.in);
       System.out.println("请输入顶点数和边数：");
       graph.verNum = scan.nextInt();
       graph.edgeNum = scan.nextInt();
       graph.vertexArray = new Vertex[graph.verNum];

       System.out.println("请依次输入顶点名称：");
       for (int i=0;i<graph.verNum;i++){
           Vertex v = new Vertex();
           v.name = scan.next();
           v.nextNode = null;
           graph.vertexArray[i] = v;
       }

       System.out.println("请依次输入图的边（如‘v1 v2’）:");
       for (int j=0;j<graph.edgeNum;j++){
           String preV = scan.next();
           String folV = scan.next();

           Vertex v1 = getVertex(graph,preV);
           Vertex reV2 = getVertex(graph,folV);
           if (v1 == null || reV2 == null){
               System.out.println("输入错误！输入的边存在没有的顶点！请重新输入：");
               j--;
               continue;
           }

           //将边的另一节点插入到链中
           Vertex v2 = new Vertex();
           v2.name = folV;

           v2.nextNode = v1.nextNode;
           v1.nextNode = v2;

           //紧接着下面注释的代码加上便是构建无向图的，不加则是构建有向图的！
//          Vertex reV1=new Vertex();
//          reV1.name=preV;
//          reV1.nextNode=reV2.nextNode;
//          reV2.nextNode=reV1;

       }

   }

    /**
     * 以邻接表的形式输出图
     * @param graph 需要输出的图
     */
   public void outputGraph(Graph graph){
       System.out.println("图的邻接表形式为：");
       for (int i=0;i<graph.verNum;i++){
           Vertex vertex = graph.vertexArray[i];
           System.out.print(vertex.name);

           Vertex current = vertex.nextNode;
           while (current != null){
               System.out.print("-->"+current.name);
               current = current.nextNode;
           }
           System.out.println();
       }
   }


}
