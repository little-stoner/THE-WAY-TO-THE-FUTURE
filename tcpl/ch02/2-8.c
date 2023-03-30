//
// Created by viber on 2023/1/28.
//

int rightrot(int x, int n) {
    return (x << (32-n+1)) | (x & ~(0 >> n));
}