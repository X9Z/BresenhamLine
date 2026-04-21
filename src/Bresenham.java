public class Bresenham {
    int i = 0;
    public int j = 0;

    private int X0;
    private int Y0;

    private int Xn;
    private int Yn;

    private int dx;
    private int dy;

    private int Xk;
    private int Yk;

    public int ArrayOfX[] = new int[3000];
    public int ArrayOfY[] = new int[3000];

    private int P0;

    public void Loop() {
        this.X0 = this.getX0();
        this.Y0 = this.getY0();

        this.Xn = this.getXn();
        this.Yn = this.getYn();

        this.dx = this.getXn() - this.getX0();
        this.dy = this.getYn() - this.getY0();
        this.Xk = this.getX0();
        this.Yk = this.getY0();
        System.out.println(dx + "======kk=====" + dy);
        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        //                     Right Up Up
        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        if (dx <= dy && dx >= 0 && dy >= 0) {

            int a = dx;
            dx = dy;
            dy = a;

            j = 0;
            System.out.println(dx + "Right Up Up" + dy);
            P0 = ((2 * dy) - dx);
            ArrayOfX[j] = Xk;
            ArrayOfY[j] = Yk;
            j++;

            while (Yk < Yn) {

                if (P0 < 0) {
                    System.out.println(Xk + " " + Yk);
                    Yk = Yk + 1;
                    ArrayOfX[j] = Xk;
                    ArrayOfY[j] = Yk;
                    P0 = (P0 + (2 * dy));
                    j++;
                } else {
                    System.out.println(Xk + " " + Yk);
                    Yk = Yk + 1;
                    Xk = Xk + 1;
                    ArrayOfX[j] = Xk;
                    ArrayOfY[j] = Yk;
                    P0 = (P0 + 2 * (dy - dx));
                    j++;
                }

            }
        }
        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        //                     Right Up Only
        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        else if (dx >= dy && dx >= 0 && dy >= 0) {
            j = 0;
            System.out.println(dx + "Right Up Only" + dy);
            P0 = ((2 * dy) - dx);
            ArrayOfX[j] = Xk;
            ArrayOfY[j] = Yk;
            j++;

            while (Xk < Xn) {

                if (P0 < 0) {
                    System.out.println(Xk + " " + Yk);
                    Xk = Xk + 1;
                    ArrayOfX[j] = Xk;
                    ArrayOfY[j] = Yk;
                    P0 = (P0 + (2 * dy));
                    j++;
                } else {
                    System.out.println(Xk + " " + Yk);
                    Xk = Xk + 1;
                    Yk = Yk + 1;
                    ArrayOfX[j] = Xk;
                    ArrayOfY[j] = Yk;
                    P0 = (P0 + 2 * (dy - dx));
                    j++;
                }

            }
        }
        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        //                     Left Up Only
        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        else if (-dx >= dy && dx <= 0 && dy >= 0) {
            dx = dx * (-1);

            j = 0;
            System.out.println(dx + "Left Up Only" + dy);
            P0 = ((2 * dy) - dx);
            ArrayOfX[j] = Xk;
            ArrayOfY[j] = Yk;
            j++;

            while (Xk > Xn) {

                if (P0 < 0) {
                    System.out.println(Xk + " " + Yk);
                    Xk = Xk - 1;
                    ArrayOfX[j] = Xk;
                    ArrayOfY[j] = Yk;
                    P0 = (P0 + (2 * dy));
                    j++;
                } else {
                    System.out.println(Xk + " " + Yk);
                    Xk = Xk - 1;
                    Yk = Yk + 1;
                    ArrayOfX[j] = Xk;
                    ArrayOfY[j] = Yk;
                    P0 = (P0 + 2 * (dy - dx));
                    j++;
                }

            }
        }
        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        //                     Left Up Up
        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        else if (-dx <= dy && dx <= 0 && dy >= 0) {
            dx = dx * (-1);
            int a = dx;
            dx = dy;
            dy = a;
            j = 0;
            System.out.println(dx + "Left Up Up" + dy);
            P0 = ((2 * dy) - dx);
            ArrayOfX[j] = Xk;
            ArrayOfY[j] = Yk;
            j++;

            while (Yk < Yn) {

                if (P0 < 0) {
                    System.out.println(Xk + " " + Yk);
                    Yk = Yk + 1;
                    ArrayOfX[j] = Xk;
                    ArrayOfY[j] = Yk;
                    P0 = (P0 + (2 * dy));
                    j++;
                } else {
                    System.out.println(Xk + " " + Yk);
                    Xk = Xk - 1;
                    Yk = Yk + 1;
                    ArrayOfX[j] = Xk;
                    ArrayOfY[j] = Yk;
                    P0 = (P0 + 2 * (dy - dx));
                    j++;
                }

            }
        }
        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        //                     Right Down Down
        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        else if (dx <= -dy && dx >= 0 && dy <= 0) {
            dy = dy * (-1);

            int a = dx;
            dx = dy;
            dy = a;
            j = 0;
            System.out.println(dx + "Right Down Down" + dy);
            P0 = ((2 * dy) - dx);
            ArrayOfX[j] = Xk;
            ArrayOfY[j] = Yk;
            j++;

            while (Yk > Yn) {

                if (P0 < 0) {
                    System.out.println(Xk + " " + Yk);
                    Yk = Yk - 1;
                    ArrayOfX[j] = Xk;
                    ArrayOfY[j] = Yk;
                    P0 = (P0 + (2 * dy));
                    j++;
                } else {
                    System.out.println(Xk + " " + Yk);
                    Xk = Xk + 1;
                    Yk = Yk - 1;
                    ArrayOfX[j] = Xk;
                    ArrayOfY[j] = Yk;
                    P0 = (P0 + 2 * (dy - dx));
                    j++;
                }

            }
        }
        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        //                     Right Down Only
        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        else if (dx >= -dy && dx >= 0 && dy <= 0) {
            dy = dy * (-1);

            j = 0;
            System.out.println(dx + "Right Down Only" + dy);
            P0 = ((2 * dy) - dx);
            ArrayOfX[j] = Xk;
            ArrayOfY[j] = Yk;
            j++;

            while (Xk < Xn) {

                if (P0 < 0) {
                    System.out.println(Xk + " " + Yk);
                    Xk = Xk + 1;
                    ArrayOfX[j] = Xk;
                    ArrayOfY[j] = Yk;
                    P0 = (P0 + (2 * dy));
                    j++;
                } else {
                    System.out.println(Xk + " " + Yk);
                    Xk = Xk + 1;
                    Yk = Yk - 1;
                    ArrayOfX[j] = Xk;
                    ArrayOfY[j] = Yk;
                    P0 = (P0 + 2 * (dy - dx));
                    j++;
                }

            }
        }
        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        //                     Left Down Only
        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        else if (-dx >= -dy && dx <= 0 && dy <= 0) {
            dx = dx * (-1);
            dy = dy * (-1);

            j = 0;
            System.out.println(dx + "Left Down Only" + dy);
            P0 = ((2 * dy) - dx);
            ArrayOfX[j] = Xk;
            ArrayOfY[j] = Yk;
            j++;

            while (Xk > Xn) {

                if (P0 < 0) {
                    System.out.println(Xk + " " + Yk);
                    Xk = Xk - 1;
                    ArrayOfX[j] = Xk;
                    ArrayOfY[j] = Yk;
                    P0 = (P0 + (2 * dy));
                    j++;
                } else {
                    System.out.println(Xk + " " + Yk);
                    Yk = Yk - 1;
                    Xk = Xk - 1;
                    ArrayOfX[j] = Xk;
                    ArrayOfY[j] = Yk;
                    P0 = (P0 + 2 * (dy - dx));
                    j++;
                }

            }
        }
        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        //                     Left Down Down
        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        else if (-dx <= -dy && dx <= 0 && dy <= 0) {
            dx = dx * (-1);
            dy = dy * (-1);
            int a = dx;
            dx = dy;
            dy = a;
            j = 0;
            System.out.println(dx + "Left Down Only" + dy);
            P0 = ((2 * dy) - dx);
            ArrayOfX[j] = Xk;
            ArrayOfY[j] = Yk;
            j++;

            while (Yk > Yn) {

                if (P0 < 0) {
                    System.out.println(Xk + " " + Yk);
                    Yk = Yk - 1;
                    ArrayOfX[j] = Xk;
                    ArrayOfY[j] = Yk;
                    P0 = (P0 + (2 * dy));
                    j++;
                } else {
                    System.out.println(Xk + " " + Yk);
                    Yk = Yk - 1;
                    Xk = Xk - 1;
                    ArrayOfX[j] = Xk;
                    ArrayOfY[j] = Yk;
                    P0 = (P0 + 2 * (dy - dx));
                    j++;
                }

            }
        }
    }


    public void setX0(int x) {
        this.X0 = x;
    }

    public void setY0(int y) {
        this.Y0 = y;
    }

    public void setXn(int x) {
        this.Xn = x;
    }

    public void setYn(int y) {
        this.Yn = y;
    }


    public int getX0() {
        return this.X0;
    }

    public int getY0() {
        return this.Y0;
    }

    public int getXn() {
        return this.Xn;
    }

    public int getYn() {
        return this.Yn;
    }
}