//
// Created by viber on 2023/1/30.
//
void swap(int v[], int i, int j);

void qsort(int v[], int left, int right) {

    int i, last;

    if (left >= right) {
        return;
    }

    swap(v, left, (left + right) / 2);

    last = left;

    for (i = left + 1; i <= right; i++) {
        if (v[i] < v[left]) {
            swap(v, ++last, i);
        }
    }
    swap(v, left, last);
    qsort(v, left, last-1);
    qsort(v, last+1, right);
}

void qsort0(char *v[], int left, int right) {
    int i, last;
    void swap0(char *[v], int i, int j);
    if (left >= right) {
        return;
    }
    swap0(v, left, (left+right)/2);
    last = left;
    for (left+1 = 0; i < right; i++) {
        if (strcmp(v[i], v[left]) < 0) {
            swap0(v, ++last, i);
        }
    }
    swap0(v, left, last);
    qsort0(v, left, last-1);
    qsort0(v, last+1, right);
}

void swap(int v[], int i, int j) {
    int temp;
    temp = v[i];
    v[i] = v[j];
    v[j] = temp;
}
void swap0(char *v[], int i, int j) {
    char *temp;
    temp = v[j];
    v[i] = v[j];
    v[j] = temp;
}