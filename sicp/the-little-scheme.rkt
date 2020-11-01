#lang scheme

(define atom?
  (lambda (x)
    (and (not (pair? x)) (not (null? x)))))

(print 'is-quote-atom?)

(atom? (quote ()))
(atom? 'atom)
(atom? 'turkey)
(atom? '1492)
(atom? 'u)
(atom? '*abc$)

(list? '(atom))
(list? '(atom turkey or))
(list? '((atom turkey) or))
(println '>>>)
(null? 'abc)
(null? '())
(eq? '() '())
(eq? 1 1)

(println '>>>>>>>>>>)
(define lat?
  (lambda (l)
    (cond
      ((null? l) #t)
      ((atom? (car l)) (lat? (cdr l)))
      (else #f))))

(lat? '(a b))
(lat? '((a) a))

(define member?
  (lambda (a lat)
    (cond
      ((null? lat) #f)
      ((eq? a (car lat)) #t)
      (else (member? a (cdr lat))))))
(define member0?
  (lambda (a lat)
    (cond
      ((null? lat) #f)
      (else
       (or (eq? a (car lat))
         (member0? a (cdr lat)))))))

(member? 'a '(c d))
(member? 'a '(a b))
(println '>>>>>>>>>>>>>>>>>>>>)
(member0? 'a '(a b))
(println '@@@@@@@@@@@@@)

(println '>>>>>>>>>>>>>>>>>>>>>>>>>>>)
(map (lambda (num1 num2) (+ num1 num2)) '(1 2 3 4) '(10 100 1000 10000))

;; this is ok.
(define r '())
(define rember
  (lambda (a lat)
    (cond
      ((null? lat) r)
      ((eq? a (car lat)) (rember a (cdr lat)))
      [else
       (set! r (cons (car lat) r))
       (rember a (cdr lat))])))

(println '>>>>>>>>>>>>>>>>>>)
;; another way to remove memeber.
(define rec
  (lambda (a lat res)
    (cond
      ((null? lat) res)
      ((eq? a (car lat)) (rec a (cdr lat) res))
      [else
       (set! res (cons (car lat) res))
       (rec a (cdr lat) res)])))
(define rember0
  (lambda (a lat)
    (rec a lat '())))



(rember 'a '(c b a))
(println '>>>>>>>>>>)
(rember0 'a '(c b a a))

(define remberx
  (lambda (a lat)
    (cond
      ((null? lat) '())
      (else (cond
              ((eq? (car lat) a) (cdr lat))
              (else
               (cons (car lat) (remberx a (cdr lat)))))))))


(println '================================================)

(define first
  (lambda (l)
    (cond
      ((null? l) '())
      [else
        (cond
          ((not (list? (car l))) (car l))
          (else
           (cons (car (car l)) (first (cdr l)))))])))
     

(first '((a b) (c d) (e f)))
(first '(((five plums) four)
         (eleven green oranges)
         ((no) more)))
(first '(a b c))

(println '>>>>>>>>>>>>>>>>>>>>>>>>>>>>>)
(println '====================================)


(define insertR
  (lambda (new old lat)
    (cond
     ((null? lat) '())
     (else
      (cond
        ((eq? (car lat) old)
         ;; insert to the right most ocurence of old element
         (if (member0? (car lat) (cdr lat)) (cons (car lat) (insertR new old (cdr lat)))
         ( cons old (cons new (cdr lat))) ))
        (else
         (cons (car lat) (insertR new old (cdr lat)))))))))

(insertR 'topping 'fudge '(ice cream with fudge for dessert))
(insertR 'jalapeno 'and '(tacos tamales and salsa))
(insertR 'a 'd '(a b c d e f g d h))

(println '=========================================)
(define insertL
  (lambda (new old lat)
    (cond
      ((null? lat) '())
      (else
        (cond
          ((eq? (car lat) old)
           ;; (cons new (cons old (cdr lat))))
           (cons new lat))
          (else
           (cons (car lat) (insertL new old (cdr lat)))))))))

(insertL 'topping 'fudge '(ice cream with fudge for dessert))
(insertL 'jalapeno 'and '(tacos tamales and salsa))
(insertL 'a 'd '(a b c d e f g d h))

(println '===================================)
(define subset
  (lambda (new old lat)
    (cond
      ((null? lat) (quote ()))
      (else (cond
              ((eq? (car lat) old)
               (cons new (cdr lat)))
              (else (cons (car lat)
                          (subset new old
                                  (cdr lat)))))))))

(println '====================================)
               
(define subset2
  (lambda (new old0 old1 lat)
    (cond
      ((null? lat) (quote ()))
      (else (cond
              ((or (eq? (car lat) old0) (eq? (car lat) old1)) (cons new (cdr lat)))
              (else (cons (car lat)
                          (subset2 new old0 old1 lat))))))))
(subset2 'vanilla 'chocolate 'banana (list 'banana 'ice 'cream 'with 'chocolate 'topping))

(println '======================================================)
(define multirember
  (lambda (a lat)
    (cond
      ((null? lat) (quote ()))
      (else
       (cond
         ((eq? a (car lat)) (multirember a (cdr lat)))
         (else (cons (car lat) (multirember a (cdr lat)))))))))

(multirember 'a '( e f g a d a))

(println '========================================)

(define multiinsertR
  (lambda (new old lat)
    (cond
      ((null? lat) (quote ()))
      (else
       (cond
         ((eq? old (car lat)) (cons old (cons new (multiinsertR new old (cdr lat)))))
         (else
          (cons (car lat) (multiinsertR new old (cdr lat)))))))))

(multiinsertR 'fried 'fish '(chips and fish or fish and fried))

(define multiinsertL
  (lambda (new old lat)
    (cond
      ((null? lat) (quote ()))
      (else
        (cond
          ;; this is not right, we can not pass the first occurence of the first old
          ;; ((eq? old (car lat)) (cons new (multiinsertL new old lat)))
          ((eq? old (car lat)) (cons new (cons old (multiinsertL new old (cdr lat)))))
          (else
           (cons (car lat) (multiinsertL new old (cdr lat)))))))))

(multiinsertL 'fried 'fish '(chips and fish or fish and fried))

(define multisubset
  (lambda (new old lat)
    (cond
      ((null? lat) (quote ()))
      (else (cond
              ((eq? (car lat) old)
               (cons new (multisubset new old (cdr lat))))
              (else (cons (car lat)
                          (multisubset new old (cdr lat)))))))))








































    