package tut7;

public class Multiplication implements OperatorWithIdentity{

    /**
     * Perform this operation with the specified operands.
     */
    @Override
    public int operate(int left, int right) {
        return left * right;
    }

    /**
     * The identity for this operator:
     *      for any int i,
     *      this.operate(this.identity(), i) ==
     *      this.operate(i, this.identity) == i
     */
    @Override
    public int identity() {
        return 1;
    }
}
