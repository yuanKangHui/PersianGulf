package item.service;

import item.domain.RBTreeNode;


public class RBTreeService {
    RBTreeNode root;
    private final boolean red = false;
    private final boolean black = true;

    public RBTreeNode query(int key) {
        RBTreeNode tmp = root;
        while (tmp != null) {
            if (tmp.getKey() == key)
                return tmp;
            else if (tmp.getKey() > key)
                tmp = tmp.getLeft();
            else
                tmp = tmp.getRight();
        }
        return null;
    }


    public void insert(int key) {
        RBTreeNode node = new RBTreeNode(key);
        if (root == null) {
            root = node;
            node.setColor(black);
            return;
        }
        RBTreeNode parent = root;
        RBTreeNode son = null;
        if (key <= parent.getKey()) {
            son = parent.getLeft();
        } else {
            son = parent.getRight();
        }
        while (son != null) {
            parent = son;
            if (key <= parent.getKey()) {
                son = parent.getLeft();
            } else {
                son = parent.getRight();
            }
        }
        if (key <= parent.getKey()) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }
        node.setParent(parent);
        insertFix(node);
    }


    private void insertFix(RBTreeNode node) {
        RBTreeNode father, grandFather;
        while ((father = node.getParent()) != null && father.getColor() == red) {
            grandFather = father.getParent();
            if (grandFather.getLeft() == father) {
                RBTreeNode uncle = grandFather.getRight();
                if (uncle != null && uncle.getColor() == red) {
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                if (node == father.getRight()) {
                    leftRotate(father);
                    RBTreeNode tmp = node;
                    node = father;
                    father = tmp;
                }
                setBlack(father);
                setRed(grandFather);
                rightRotate(grandFather);
            } else {
                RBTreeNode uncle = grandFather.getLeft();
                if (uncle != null && uncle.getColor() == red) {
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                if (node == father.getLeft()) {
                    rightRotate(father);
                    RBTreeNode tmp = node;
                    node = father;
                    father = tmp;
                }
                setBlack(father);
                setRed(grandFather);
                leftRotate(grandFather);
            }
        }
        setBlack(root);
    }

    public void delete(int key) {
        delete(query(key));
    }

    private void delete(RBTreeNode node) {
        if (node == null)
            return;
        if (node.getLeft() != null && node.getRight() != null) {
            RBTreeNode replaceNode = node;
            RBTreeNode tmp = node.getRight();
            while (tmp != null) {
                replaceNode = tmp;
                tmp = tmp.getLeft();
            }
            int t = replaceNode.getKey();
            replaceNode.setKey(node.getKey());
            node.setKey(t);
            delete(replaceNode);
            return;
        }
        RBTreeNode replaceNode = null;
        if (node.getLeft() != null)
            replaceNode = node.getLeft();
        else replaceNode = node.getRight();

        RBTreeNode parent = node.getParent();
        if (parent == null) {
            root = replaceNode;
            if (replaceNode != null)
                replaceNode.setParent(null);
        } else {
            if (replaceNode != null)
                replaceNode.setParent(parent);
            if (parent.getLeft() == node)
                parent.setLeft(replaceNode);
            else {
                parent.setRight(replaceNode);
            }
        }
        if (node.getColor() == black)
            removeFix(parent, replaceNode);
    }

    private void removeFix(RBTreeNode father, RBTreeNode node) {
        while ((node == null || node.getColor() == black) && node != root) {
            if (father.getLeft() == node) {
                RBTreeNode brother = father.getRight();
                if (brother != null && brother.getColor() == red) {
                    setRed(father);
                    setBlack(brother);
                    leftRotate(father);
                    brother = father.getRight();
                }
                if (brother == null || (isBlack(brother.getLeft())) && isBlack(brother.getRight())) {
                    setRed(brother);
                    node = father;
                    father = node.getParent();
                    continue;
                }
                if (isRed(brother.getLeft())) {
                    setBlack(brother.getLeft());
                    setRed(brother);
                    rightRotate(brother);
                    brother = brother.getParent();
                }

                brother.setColor((father.getColor()));
                setBlack(father);
                setBlack(brother.getRight());
                leftRotate(father);
                node = root;
            } else {
                RBTreeNode brother = father.getLeft();
                if (brother != null && brother.getColor() == red) {
                    setRed(father);
                    setBlack(brother);
                    rightRotate(father);
                    brother = father.getLeft();
                }
                if (brother == null || (isBlack(brother.getLeft()) && isBlack(brother.getRight()))) {
                    setRed(brother);
                    node = father;
                    father = node.getParent();
                    continue;
                }
                if (isRed(brother.getRight())) {
                    setBlack(brother.getRight());
                    setRed(brother);
                    leftRotate(brother);
                    brother = brother.getParent();
                }
                brother.setColor(father.getColor());
                setBlack(father);
                setBlack(brother.getLeft());
                rightRotate(father);
                node = root;
            }
        }
        if (node != null)
            node.setColor(black);
    }

    private boolean isBlack(RBTreeNode node) {
        if (node == null)
            return true;
        return node.getColor() == black;
    }

    private boolean isRed(RBTreeNode node) {
        if (node == null)
            return true;
        return node.getColor() == red;
    }

    private void leftRotate(RBTreeNode node) {
        RBTreeNode right = node.getRight();
        RBTreeNode parent = node.getParent();
        if (parent == null) {
            root = right;
            right.setParent(null);
        } else {
            if (parent.getLeft() != null && parent.getLeft() == node) {
                parent.setLeft(right);
            } else {
                parent.setRight(parent);
            }
            right.setParent(parent);
        }
        node.setParent(right);
        node.setRight(right.getLeft());
        if (right.getLeft() != null) {
            right.getLeft().setParent(node);
        }
        right.setLeft(node);
    }

    private void rightRotate(RBTreeNode node) {
        RBTreeNode left = node.getLeft();
        RBTreeNode parent = node.getParent();
        if (parent == null) {
            root = left;
            left.setParent(null);
        } else {
            if (parent.getLeft() != null && parent.getLeft() == node) {
                parent.setLeft(left);
            } else {
                parent.setRight(left);
            }
            left.setParent(parent);
        }
        node.setParent(left);
        node.setLeft(left.getRight());
        if (left.getRight() != null) {
            left.getRight().setParent(node);
        }
        left.setRight(node);
    }

    private void setBlack(RBTreeNode node) {
        if (node != null) {
            node.setColor(black);
        }
    }

    private void setRed(RBTreeNode node) {
        if (node != null) {
            node.setColor(red);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(RBTreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.println(node);
        inOrder(node.getRight());
    }
}
