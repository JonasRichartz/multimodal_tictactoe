public class GestureDeclaration {

    double[][] gestureArray_x;
    double[][] gestureArray_y;
    double[][] gestureArray_angles; //used for sole gesture Input
    double[][] gestureArray_angles_mmi; //used for gesture Input while Mmi is active

    public GestureDeclaration() {
        double [] up_x = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 2.0, 3.0, 3.0, 4.0, 4.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 4.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0};
        double [] up_y = {0.0, -1.0, -4.0, -5.0, -8.0, -11.0, -14.0, -16.0, -19.0, -22.0, -26.0, -30.0, -34.0, -40.0, -44.0, -48.0, -52.0, -56.0, -59.0, -61.0, -64.0, -66.0, -68.0, -69.0, -71.0, -71.0, -73.0, -74.0, -76.0, -76.0, -77.0, -79.0, -80.0, -80.0, -81.0, -83.0, -84.0, -84.0, -85.0, -87.0, -88.0, -89.0, -90.0, -91.0, -92.0, -92.0, -93.0, -94.0, -94.0};

        double [] down_x = {0.0, 0.0, 0.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -2.0, -2.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -4.0, -4.0, -4.0, -4.0, -4.0, -4.0, -5.0, -6.0, -6.0, -7.0, -7.0, -7.0};
        double [] down_y = {0.0, 0.0, 2.0, 20.0, 22.0, 26.0, 29.0, 31.0, 34.0, 36.0, 37.0, 40.0, 42.0, 43.0, 44.0, 47.0, 48.0, 50.0, 52.0, 54.0, 56.0, 60.0, 61.0, 64.0, 65.0, 66.0, 68.0, 69.0, 70.0, 72.0, 72.0, 73.0, 74.0, 75.0, 75.0};

        double [] left_x = {0.0, -1.0, -9.0, -13.0, -17.0, -21.0, -24.0, -27.0, -29.0, -32.0, -33.0, -34.0, -36.0, -37.0, -37.0, -39.0, -40.0, -41.0, -43.0, -45.0, -47.0, -48.0, -49.0, -49.0, -51.0, -54.0, -57.0, -59.0, -61.0, -62.0, -64.0, -65.0, -66.0, -67.0, -68.0, -68.0, -69.0, -72.0, -75.0, -77.0, -80.0, -81.0, -82.0, -82.0};
        double [] left_y = {0.0, -1.0, -2.0, -2.0, -2.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};

        double [] right_x = {0.0, 1.0, 2.0, 2.0, 3.0, 5.0, 6.0, 7.0, 10.0, 11.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0, 21.0, 22.0, 22.0, 23.0, 24.0, 25.0, 26.0, 26.0, 28.0, 30.0, 30.0, 31.0, 32.0, 33.0, 34.0, 35.0, 36.0, 38.0, 38.0, 39.0, 40.0, 41.0, 42.0, 43.0, 44.0, 45.0, 46.0, 46.0, 47.0, 48.0, 49.0, 50.0, 51.0, 52.0, 54.0, 54.0, 55.0, 56.0, 57.0, 58.0, 58.0};
        double [] right_y = {0.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -2.0, -2.0, -2.0, -2.0};

        double [] up_left_x = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -2.0, -4.0, -4.0, -5.0, -6.0, -7.0, -8.0, -10.0, -11.0, -12.0, -13.0, -14.0, -16.0, -16.0, -18.0, -20.0, -21.0, -22.0, -23.0, -24.0, -24.0, -26.0, -27.0, -28.0, -29.0, -30.0, -31.0, -33.0, -35.0, -36.0, -37.0, -38.0, -39.0, -40.0, -40.0, -41.0, -42.0, -43.0, -45.0, -47.0, -48.0, -50.0, -50.0, -51.0, -52.0, -52.0, -53.0, -54.0, -55.0, -56.0, -56.0, -57.0, -59.0, -59.0};
        double [] up_left_y = {0.0, 0.0, -2.0, -6.0, -8.0, -9.0, -11.0, -12.0, -12.0, -13.0, -15.0, -16.0, -17.0, -19.0, -20.0, -20.0, -22.0, -24.0, -25.0, -26.0, -28.0, -28.0, -29.0, -30.0, -32.0, -32.0, -33.0, -34.0, -36.0, -36.0, -38.0, -39.0, -40.0, -41.0, -42.0, -43.0, -44.0, -45.0, -47.0, -48.0, -50.0, -52.0, -52.0, -54.0, -55.0, -56.0, -57.0, -58.0, -60.0, -60.0, -61.0, -62.0, -63.0, -63.0, -64.0, -64.0, -65.0, -66.0, -67.0, -67.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -66.0, -65.0, -65.0, -64.0, -64.0, -64.0, -64.0, -64.0, -63.0, -62.0, -62.0, -62.0, -62.0, -62.0, -62.0, -62.0, -62.0, -62.0};

        double [] up_right_x = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 2.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 4.0, 5.0, 7.0, 9.0, 11.0, 11.0, 12.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0, 22.0, 23.0, 24.0, 25.0, 26.0, 27.0, 28.0, 29.0, 30.0, 31.0, 31.0, 32.0, 33.0, 34.0, 35.0, 37.0, 38.0, 39.0, 42.0, 43.0, 44.0, 46.0, 47.0, 47.0, 48.0, 49.0, 50.0, 50.0, 51.0, 51.0, 52.0, 52.0, 52.0};
        double [] up_right_y = {0.0, -1.0, -2.0, -4.0, -5.0, -5.0, -6.0, -7.0, -9.0, -9.0, -9.0, -11.0, -12.0, -13.0, -13.0, -14.0, -15.0, -16.0, -17.0, -17.0, -18.0, -19.0, -20.0, -21.0, -22.0, -23.0, -24.0, -25.0, -26.0, -29.0, -29.0, -30.0, -31.0, -32.0, -33.0, -33.0, -35.0, -36.0, -37.0, -38.0, -39.0, -40.0, -41.0, -41.0, -42.0, -43.0, -44.0, -45.0, -45.0, -47.0, -48.0, -49.0, -49.0, -50.0, -50.0, -52.0, -53.0, -53.0, -54.0, -55.0, -56.0, -57.0, -58.0, -59.0, -60.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -61.0, -62.0, -62.0};

        double [] down_left_x = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -1.0, -1.0, -1.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -3.0, -4.0, -7.0, -8.0, -10.0, -13.0, -15.0, -18.0, -19.0, -23.0, -25.0, -27.0, -29.0, -31.0, -32.0, -35.0, -38.0, -40.0, -43.0, -46.0, -47.0, -49.0, -50.0, -51.0, -52.0, -53.0, -54.0, -55.0, -57.0, -58.0, -59.0, -60.0, -61.0, -62.0, -63.0, -63.0, -64.0, -65.0, -65.0};
        double [] down_left_y = {0.0, 0.0, 1.0, 2.0, 3.0, 4.0, 6.0, 8.0, 10.0, 11.0, 12.0, 13.0, 15.0, 16.0, 17.0, 19.0, 20.0, 21.0, 22.0, 23.0, 24.0, 26.0, 28.0, 28.0, 30.0, 32.0, 33.0, 35.0, 36.0, 37.0, 39.0, 40.0, 41.0, 43.0, 44.0, 45.0, 46.0, 48.0, 48.0, 50.0, 52.0, 52.0, 53.0, 54.0, 56.0, 57.0, 58.0, 59.0, 60.0, 61.0, 63.0, 63.0, 64.0, 64.0, 65.0, 66.0, 66.0, 66.0, 66.0, 66.0, 66.0, 66.0, 66.0, 66.0, 66.0, 66.0, 65.0, 65.0, 65.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0, 64.0};

        double [] down_right_x = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 4.0, 5.0, 6.0, 8.0, 10.0, 12.0, 13.0, 16.0, 18.0, 20.0, 22.0, 24.0, 27.0, 30.0, 33.0, 36.0, 39.0, 43.0, 45.0, 48.0, 48.0, 50.0, 51.0, 52.0, 54.0, 56.0, 57.0, 60.0, 61.0, 63.0, 64.0, 64.0, 65.0, 66.0, 67.0, 68.0, 68.0, 68.0};
        double [] down_right_y = {0.0, 2.0, 8.0, 8.0, 10.0, 12.0, 12.0, 14.0, 16.0, 17.0, 19.0, 20.0, 22.0, 24.0, 25.0, 26.0, 27.0, 28.0, 28.0, 28.0, 29.0, 30.0, 32.0, 33.0, 34.0, 36.0, 37.0, 39.0, 40.0, 41.0, 42.0, 44.0, 45.0, 46.0, 47.0, 48.0, 48.0, 49.0, 50.0, 51.0, 52.0, 52.0, 53.0, 54.0, 55.0, 56.0, 57.0, 58.0, 59.0, 60.0, 61.0, 63.0, 64.0, 65.0, 66.0, 67.0, 68.0, 68.0, 68.0, 68.0, 68.0, 69.0, 69.0, 70.0, 70.0, 70.0, 71.0, 71.0, 71.0, 71.0, 71.0, 71.0, 72.0, 72.0, 72.0, 72.0, 72.0, 72.0, 72.0, 72.0, 72.0, 72.0, 72.0, 72.0, 72.0, 72.0, 72.0, 72.0, 72.0, 72.0, 72.0, 72.0, 72.0, 71.0, 71.0, 71.0, 71.0, 71.0};

        double [] middle_x = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 2.0, 3.0, 3.0, 4.0, 4.0, 4.0, 4.0, 5.0, 5.0, 6.0, 8.0, 8.0, 9.0, 9.0, 9.0, 10.0, 10.0, 10.0, 11.0, 11.0, 12.0, 12.0, 13.0, 13.0, 14.0, 17.0, 18.0, 21.0, 22.0, 24.0, 26.0, 28.0, 29.0, 30.0, 32.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 32.0, 32.0, 31.0, 31.0, 30.0, 30.0, 30.0, 30.0, };
        double [] middle_y = {0.0, -1.0, -2.0, -3.0, -4.0, -6.0, -8.0, -9.0, -10.0, -12.0, -12.0, -14.0, -16.0, -17.0, -19.0, -20.0, -22.0, -24.0, -25.0, -27.0, -28.0, -31.0, -32.0, -33.0, -36.0, -37.0, -39.0, -40.0, -41.0, -43.0, -44.0, -44.0, -45.0, -44.0, -42.0, -40.0, -39.0, -36.0, -36.0, -34.0, -32.0, -31.0, -30.0, -29.0, -29.0, -28.0, -27.0, -26.0, -26.0, -27.0, -29.0, -32.0, -33.0, -36.0, -38.0, -40.0, -42.0, -44.0, -45.0, -48.0, -49.0, -50.0, -49.0, -48.0, -45.0, -43.0, -41.0, -38.0, -36.0, -34.0, -32.0, -28.0, -27.0, -24.0, -22.0, -21.0, -20.0, -17.0, -16.0, -15.0, -14.0, -12.0, -10.0, -8.0, -8.0, -6.0, -4.0, -4.0, -3.0, -3.0};

        double [] startGame_x = {0.0, 0.0, 0.0, 0.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 0.0, 2.0, 3.0, 5.0, 6.0, 7.0, 9.0, 10.0, 12.0, 13.0, 13.0, 14.0, 14.0, 16.0, 17.0, 17.0, 17.0, 18.0, 19.0, 20.0, 21.0, 21.0, 22.0, 23.0, 23.0, 24.0, 25.0, 25.0, 25.0, 25.0, 26.0, 27.0, 28.0, 29.0, 29.0, 30.0, 31.0, 31.0, 30.0, 29.0, 29.0, 28.0, 28.0, 27.0, 26.0, 25.0, 25.0, 24.0, 23.0, 22.0, 21.0, 21.0, 20.0, 19.0, 19.0, 18.0, 17.0, 17.0, 16.0, 15.0, 15.0, 13.0, 13.0, 13.0, 11.0, 10.0, 9.0, 9.0, 8.0, 6.0, 5.0, 5.0, 4.0, 3.0, 2.0, 2.0, 1.0, 1.0};
        double [] startGame_y = {0.0, -1.0, -1.0, -3.0, -5.0, -5.0, -8.0, -9.0, -11.0, -13.0, -14.0, -16.0, -17.0, -19.0, -21.0, -22.0, -23.0, -25.0, -25.0, -26.0, -27.0, -28.0, -29.0, -29.0, -30.0, -31.0, -32.0, -33.0, -34.0, -36.0, -37.0, -37.0, -38.0, -39.0, -40.0, -41.0, -42.0, -43.0, -44.0, -44.0, -42.0, -41.0, -41.0, -40.0, -40.0, -39.0, -38.0, -37.0, -37.0, -37.0, -37.0, -36.0, -36.0, -35.0, -34.0, -33.0, -33.0, -33.0, -33.0, -32.0, -32.0, -31.0, -31.0, -30.0, -29.0, -29.0, -29.0, -29.0, -28.0, -28.0, -27.0, -26.0, -25.0, -25.0, -25.0, -25.0, -24.0, -24.0, -23.0, -22.0, -22.0, -21.0, -21.0, -21.0, -21.0, -21.0, -20.0, -20.0, -19.0, -18.0, -18.0, -17.0, -17.0, -17.0, -17.0, -16.0, -16.0, -16.0, -16.0, -15.0, -15.0, -14.0, -13.0, -13.0, -13.0, -12.0, -11.0, -11.0, -11.0, -11.0, -11.0, -11.0, -10.0, -10.0, -9.0, -9.0, -9.0};

        double [] quitGame_x = {0.0, -1.0, -1.0, -1.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 0.0, 6.0, 9.0, 13.0, 16.0, 19.0, 20.0, 21.0, 21.0, 22.0, 23.0, 24.0, 27.0, 29.0, 31.0, 31.0, 32.0, 32.0, 31.0, 31.0, 31.0, 31.0, 30.0, 29.0, 29.0, 28.0, 28.0, 28.0, 28.0, 27.0, 27.0, 27.0, 27.0, 27.0, 27.0, 27.0, 27.0, 27.0, 27.0, 27.0, 27.0, 25.0, 22.0, 19.0, 16.0, 15.0, 11.0, 8.0, 6.0, 4.0, 3.0, 3.0, 3.0};
        double [] quitGame_y = {0.0, 0.0, -1.0, -2.0, -4.0, -6.0, -8.0, -10.0, -12.0, -14.0, -16.0, -19.0, -21.0, -23.0, -25.0, -26.0, -28.0, -29.0, -31.0, -32.0, -32.0, -33.0, -34.0, -34.0, -34.0, -33.0, -32.0, -32.0, -32.0, -32.0, -32.0, -32.0, -31.0, -31.0, -30.0, -30.0, -29.0, -28.0, -28.0, -28.0, -28.0, -28.0, -27.0, -26.0, -24.0, -21.0, -20.0, -18.0, -16.0, -16.0, -15.0, -13.0, -12.0, -12.0, -11.0, -10.0, -9.0, -8.0, -8.0, -7.0, -6.0, -5.0, -4.0, -4.0, -4.0, -5.0, -6.0, -7.0, -8.0, -8.0, -8.0, -8.0, -8.0, -8.0, -8.0, -8.0, -8.0};

        double [] line_angles = {171.0, 173.0, 171.0, 171.0, 172.0, 172.0, 172.0, 172.0, 172.0, 174.0, 172.0, 172.0, 172.0, 172.0, 172.0, 172.0, 172.0, 172.0, 172.0, 172.0, 172.0, 135.0, 172.0, 172.0, 174.0, 92.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0};
        double [] corner_angles = {169.0, 170.0, 171.0, 171.0, 171.0, 171.0, 171.0, 135.0, 169.0, 170.0, 95.0, 167.0, 167.0, 168.0, 168.0, 169.0, 169.0, 169.0, 170.0, 170.0, 170.0, 170.0, 170.0, 170.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 174.0, 172.0, 172.0, 172.0, 172.0, 172.0, 172.0, 174.0, 172.0, 172.0, 172.0, 172.0, 172.0, 92.0, 93.0, 95.0, 96.0, 98.0, 100.0, 101.0, 104.0, 106.0, 107.0, 108.0, 109.0, 109.0, 110.0, 111.0, 113.0, 114.0, 116.0, 116.0, 118.0, 119.0, 120.0, 121.0, 122.0, 123.0, 124.0, 125.0, 126.0, 126.0, 127.0, 128.0, 128.0, 129.0, 130.0, 130.0, 132.0, 133.0, 135.0, 136.0,};
        double [] center_angles = {90.0, 170.0, 134.0, 123.0, 169.0, 128.0, 172.0, 165.0, 143.0, 158.0, 166.0, 154.0, 158.0, 161.0, 162.0, 163.0, 138.0, 165.0, 140.0, 142.0, 125.0, 153.0, 155.0, 130.0, 143.0, 134.0, 136.0, 126.0, 148.0, 160.0, 143.0, 133.0, 146.0, 147.0, 103.0, 149.0, 105.0, 133.0, 152.0, 108.0, 110.0, 111.0, 112.0, 114.0, 115.0, 115.0, 117.0, 118.0, 119.0, 94.0, 88.0, 105.0, 107.0, 82.0, 103.0, 98.0, 78.0, 110.0, 94.0, 85.0, 87.0, 92.0, 84.0, 82.0, 75.0, 80.0, 69.0, 70.0, 72.0, 55.0, 75.0, 66.0, 35.0, 62.0, 82.0, 39.0, 40.0, 10.0, 22.0, 40.0, 24.0};
        double [] startGame_angles = {170.0, 173.0, 174.0, 172.0, 174.0, 174.0, 172.0, 174.0, 174.0, 172.0, 174.0, 172.0, 172.0, 172.0, 172.0, 135.0, 172.0, 172.0, 137.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 173.0, 173.0, 171.0, 171.0, 156.0, 171.0, 171.0, 171.0, 173.0, 171.0, 173.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 171.0, 174.0, 171.0, 171.0, 171.0, 172.0, 172.0, 48.0, 49.0, 51.0, 52.0, 53.0, 13.0, 73.0, 39.0, 59.0, 78.0, 62.0, 45.0, 65.0, 87.0, 71.0, 91.0, 56.0, 95.0, 79.0, 83.0, 131.0, 99.0, 103.0, 96.0, 123.0, 116.0, 134.0, 121.0, 113.0, 160.0, 116.0, 118.0, 165.0, 139.0, 140.0, 123.0, 124.0, 169.0, 81.0, 168.0, 126.0, 82.0, 171.0, 128.0, 8.0, 96.0, 52.0, 11.0, 11.0, 11.0, 11.0, 12.0, 12.0, 10.0, 10.0, 11.0, 18.0, 10.0, 10.0, 12.0, 10.0, 18.0, 11.0, 38.0, 12.0, 8.0, 9.0, 12.0, 13.0, 7.0, 42.0, 5.0, 8.0, 8.0, 25.0, 8.0, 45.0, 5.0, 30.0, 11.0, 11.0, 35.0, 16.0, 17.0, 17.0, 68.0, 34.0, 53.0, 90.0, 90.0, 101.0, 157.0};
        double [] quitGame_angles = {169.0, 170.0, 173.0, 171.0, 173.0, 174.0, 174.0, 174.0, 174.0, 172.0, 174.0, 161.0, 137.0, 166.0, 171.0, 159.0, 169.0, 171.0, 169.0, 171.0, 171.0, 172.0, 172.0, 170.0, 170.0, 170.0, 170.0, 95.0, 170.0, 172.0, 140.0, 169.0, 170.0, 171.0, 170.0, 172.0, 170.0, 170.0, 172.0, 170.0, 140.0, 171.0, 170.0, 172.0, 170.0, 172.0, 172.0, 170.0, 172.0, 172.0, 170.0, 172.0, 171.0, 171.0, 173.0, 171.0, 171.0, 171.0, 171.0, 171.0, 94.0, 69.0, 52.0, 52.0, 53.0, 99.0, 99.0, 100.0, 100.0, 101.0, 102.0, 103.0, 104.0, 105.0, 106.0, 107.0, 108.0, 109.0, 110.0, 111.0, 112.0, 113.0, 114.0, 114.0, 115.0, 116.0, 117.0, 118.0, 118.0, 119.0, 120.0, 120.0, 121.0, 122.0, 123.0, 124.0, 125.0, 125.0, 125.0, 126.0, 127.0, 127.0, 128.0, 128.0, 129.0, 129.0, 130.0, 130.0, 131.0, 157.0, 131.0, 132.0, 133.0, 133.0, 134.0, 134.0, 135.0, 136.0, 173.0, 136.0, 137.0, 137.0, 137.0, 49.0, 42.0, 49.0, 23.0, 49.0, 8.0, 50.0, 24.0, 9.0, 25.0, 52.0, 52.0, 52.0, 38.0, 53.0, 11.0, 54.0, 11.0, 54.0, 12.0, 55.0, 56.0, 57.0, 30.0, 31.0, 58.0, 58.0, 34.0, 61.0, 62.0, 36.0, 63.0, 64.0, 65.0, 66.0, 66.0, 23.0, 68.0, 43.0, 71.0, 71.0, 73.0, 47.0, 75.0, 76.0, 77.0, 78.0, 79.0, 35.0, 80.0, 82.0, 82.0, 83.0, 84.0, 85.0, 86.0, 86.0, 87.0, 88.0, 8.0, 28.0, 8.0, 8.0, 5.0, 5.0, 8.0, 8.0, 6.0, 8.0, 8.0, 6.0, 8.0, 8.0, 9.0, 6.0, 9.0, 6.0, 9.0, 9.0, 24.0, 8.0, 5.0, 43.0, 8.0, 8.0, 26.0, 6.0, 27.0, 8.0, 6.0, 47.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 8.0, 10.0, 10.0, 8.0, 11.0, 11.0, 11.0, 12.0, 12.0, 13.0, 14.0, 15.0, 16.0, 18.0, 27.0, 13.0, 76.0};

        double [] place_angles = {170.0, 173.0, 174.0, 174.0, 174.0, 174.0, 175.0, 172.0, 161.0, 174.0, 174.0, 172.0, 174.0, 172.0, 172.0, 174.0, 172.0, 174.0, 172.0, 172.0, 174.0, 172.0, 172.0, 172.0, 175.0, 172.0, 174.0, 172.0, 175.0, 172.0, 175.0, 174.0, 175.0, 174.0, 175.0, 175.0, 176.0, 175.0, 175.0, 175.0, 175.0, 175.0, 174.0, 175.0, 174.0, 175.0, 162.0, 174.0, 175.0, 175.0, 175.0, 172.0, 175.0, 175.0, 174.0, 176.0, 176.0, 175.0, 160.0, 153.0, 153.0, 153.0, 175.0, 135.0, 136.0, 174.0, 136.0, 92.0, 92.0, 93.0, 94.0, 95.0, 96.0, 79.0, 72.0, 81.0, 86.0, 57.0, 69.0, 85.0, 105.0, 61.0, 107.0, 81.0, 82.0, 64.0, 83.0, 66.0, 66.0, 79.0, 114.0, 51.0, 70.0, 116.0, 71.0, 54.0, 73.0, 74.0, 56.0, 57.0, 58.0, 32.0, 33.0, 33.0, 34.0, 35.0, 34.0, 36.0, 35.0, 36.0, 37.0, 37.0, 19.0, 10.0, 12.0, 12.0, 38.0, 40.0, 14.0, 14.0, 7.0, 40.0, 8.0, 50.0, 9.0, 40.0, 51.0, 52.0, 53.0, 10.0, 53.0, 54.0, 36.0, 56.0, 56.0, 58.0, 59.0, 61.0, 63.0, 65.0, 67.0, 69.0, 71.0, 73.0, 75.0, 78.0, 80.0, 82.0, 83.0, 85.0, 87.0, 88.0, 88.0, 89.0, 91.0, 92.0, 93.0, 94.0, 95.0, 96.0};
        double [] action_angles = {134.0, 172.0, 143.0, 141.0, 167.0, 153.0, 165.0, 175.0, 161.0, 159.0, 175.0, 175.0, 173.0, 168.0, 173.0, 175.0, 175.0, 176.0, 175.0, 176.0, 162.0, 175.0, 162.0, 175.0, 170.0, 175.0, 163.0, 171.0, 158.0, 156.0, 157.0, 164.0, 164.0, 174.0, 164.0, 174.0, 165.0, 157.0, 166.0, 173.0, 158.0, 147.0, 158.0, 173.0, 172.0, 167.0, 172.0, 159.0, 174.0, 160.0, 170.0, 174.0, 142.0, 161.0, 142.0, 169.0, 169.0, 143.0, 169.0, 169.0, 143.0, 37.0, 37.0, 37.0, 37.0, 38.0, 38.0, 39.0, 40.0, 41.0, 42.0, 44.0, 33.0, 46.0, 33.0, 48.0, 49.0, 32.0, 51.0, 41.0, 54.0, 69.0, 57.0, 73.0, 76.0, 82.0, 66.0, 95.0, 69.0, 89.0, 73.0, 138.0, 75.0, 78.0, 98.0, 82.0, 84.0, 104.0, 87.0, 107.0, 117.0, 92.0, 94.0, 95.0, 96.0, 123.0, 98.0, 168.0, 98.0, 81.0, 82.0, 38.0, 56.0, 84.0, 66.0, 49.0, 43.0, 56.0, 46.0, 79.0, 59.0, 65.0, 67.0, 58.0, 60.0, 81.0, 64.0, 67.0, 79.0, 71.0, 116.0, 73.0, 74.0, 94.0, 78.0, 80.0, 127.0, 83.0, 66.0, 86.0, 88.0, 72.0, 47.0, 82.0, 78.0, 53.0, 54.0, 100.0, 101.0, 58.0, 58.0, 104.0, 105.0, 61.0, 63.0, 117.0, 99.0, 109.0, 115.0, 119.0, 132.0, 136.0, 140.0, 142.0, 145.0, 147.0, 149.0, 151.0, 152.0, 153.0, 154.0, 141.0, 156.0, 156.0, 157.0, 157.0, 158.0, 158.0, 158.0, 159.0, 155.0};
        double [] x_angles = {170.0, 172.0, 160.0, 166.0, 169.0, 167.0, 151.0, 140.0, 168.0, 125.0, 167.0, 169.0, 170.0, 141.0, 169.0, 169.0, 170.0, 170.0, 154.0, 140.0, 171.0, 140.0, 174.0, 154.0, 141.0, 171.0, 154.0, 141.0, 153.0, 167.0, 170.0, 141.0, 170.0, 170.0, 170.0, 170.0, 141.0, 168.0, 169.0, 168.0, 169.0, 169.0, 153.0, 168.0, 168.0, 160.0, 168.0, 127.0, 167.0, 167.0, 170.0, 154.0, 171.0, 171.0, 171.0, 167.0, 171.0, 128.0, 141.0, 128.0, 171.0, 141.0, 26.0, 34.0, 53.0, 55.0, 56.0, 57.0, 59.0, 60.0, 62.0, 63.0, 65.0, 66.0, 67.0, 68.0, 70.0, 70.0, 45.0, 73.0, 74.0, 76.0, 78.0, 81.0, 82.0, 84.0, 86.0, 114.0, 89.0, 89.0, 90.0, 91.0, 92.0, 94.0, 96.0, 97.0, 99.0, 101.0, 130.0, 105.0, 106.0, 106.0, 108.0, 110.0, 111.0, 113.0, 115.0, 135.0, 19.0, 18.0, 37.0, 31.0, 32.0, 22.0, 50.0, 25.0, 53.0, 47.0, 32.0, 50.0, 78.0, 36.0, 81.0, 20.0, 57.0, 41.0, 23.0, 87.0, 63.0, 46.0, 48.0, 77.0, 54.0, 76.0, 78.0, 74.0, 67.0, 95.0, 72.0, 85.0, 105.0, 101.0, 103.0, 87.0, 120.0, 105.0, 120.0, 121.0, 137.0, 132.0, 136.0, 127.0, 136.0, 165.0, 139.0, 150.0, 124.0, 169.0, 125.0, 170.0, 157.0, 154.0, 155.0, 173.0, 173.0, 170.0, 148.0, 173.0, 85.0};
        double [] o_angles = {169.0, 134.0, 160.0, 166.0, 167.0, 170.0, 172.0, 172.0, 174.0, 173.0, 173.0, 158.0, 168.0, 170.0, 169.0, 168.0, 164.0, 176.0, 161.0, 159.0, 169.0, 147.0, 176.0, 158.0, 162.0, 163.0, 163.0, 153.0, 162.0, 154.0, 154.0, 129.0, 145.0, 131.0, 114.0, 134.0, 116.0, 117.0, 92.0, 119.0, 94.0, 76.0, 95.0, 78.0, 79.0, 68.0, 81.0, 56.0, 72.0, 54.0, 53.0, 44.0, 60.0, 47.0, 49.0, 51.0, 53.0, 56.0, 59.0, 62.0, 64.0, 59.0, 72.0, 74.0, 63.0, 80.0, 54.0, 82.0, 38.0, 65.0, 41.0, 86.0, 25.0, 62.0, 64.0, 92.0, 31.0, 32.0, 96.0, 36.0, 55.0, 102.0, 14.0, 16.0, 103.0, 17.0, 60.0, 19.0, 19.0, 63.0, 46.0, 22.0, 23.0, 23.0, 23.0, 24.0, 24.0, 24.0, 26.0, 26.0, 28.0, 29.0, 31.0, 31.0, 34.0, 34.0, 12.0, 38.0, 6.0, 14.0, 42.0, 47.0, 41.0, 46.0, 7.0, 21.0, 8.0, 40.0, 7.0, 7.0, 7.0, 8.0, 22.0, 10.0, 12.0, 90.0, 135.0, 153.0, 168.0, 169.0, 169.0, 96.0, 166.0, 167.0, 169.0, 168.0, 170.0, 171.0, 172.0, 172.0, 172.0, 86.0, 151.0, 90.0, 155.0, 94.0, 144.0, 101.0, 131.0, 107.0, 112.0, 87.0, 117.0, 102.0, 98.0, 83.0, 67.0, 89.0, 75.0, 70.0, 102.0, 93.0, 65.0, 84.0, 76.0, 87.0, 95.0, 102.0, 108.0, 113.0, 117.0, 118.0, 120.0, 33.0, 123.0, 81.0, 83.0, 132.0, 102.0, 122.0, 118.0, 146.0, 103.0, 106.0, 126.0, 65.0, 155.0, 67.0, 94.0, 159.0, 159.0, 116.0, 72.0, 73.0, 162.0};

        gestureArray_x = new double[][]{up_x, down_x, left_x, right_x, up_left_x, up_right_x, down_left_x, down_right_x, middle_x, startGame_x, quitGame_x};
        gestureArray_y = new double[][]{up_y, down_y, left_y, right_y, up_left_y, up_right_y, down_left_y, down_right_y, middle_y, startGame_y, quitGame_y};
        gestureArray_angles = new double[][]{line_angles, corner_angles, center_angles, startGame_angles, quitGame_angles};
        gestureArray_angles_mmi = new double[][]{line_angles, corner_angles, center_angles, startGame_angles, quitGame_angles, place_angles, action_angles, x_angles, o_angles};
    }
}