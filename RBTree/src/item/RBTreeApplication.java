package item;

import item.domain.RBTreeNode;
import item.service.RBTreeService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RBTreeApplication {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        try {
            Class<?> cls = Class.forName("item.service.RBTreeService");
            RBTreeService service = (RBTreeService) cls.newInstance();
            service.insert(12);
            service.insert(1);
            service.insert(9);
            service.insert(2);
            service.insert(0);
            service.insert(4);
            service.inOrder();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        long late = System.currentTimeMillis();
        System.out.println("代码执行时间：" + (late - before));
    }
}
