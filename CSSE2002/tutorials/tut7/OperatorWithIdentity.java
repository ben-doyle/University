package tut7;

public interface OperatorWithIdentity {

    /**
     * Perform this operation with the specified operands.
     */
    int operate(int left, int right);

    /**
     * The identity for this operator:
     *      for any int i,
     *      this.operate(this.identity(), i) ==
     *      this.operate(i, this.identity) == i
     */
    int identity();
}
