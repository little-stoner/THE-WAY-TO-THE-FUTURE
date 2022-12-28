#lang scheme
(define (atom? x)
  (and (not (null? x))
       (not (pair? x))))

(define lat?
  (lambda (l)
    (cond
      ((null? l) #t)
      ((atom? (car l)) (lat? (cdr l)))
      (else #f)
    )
  )
)

(define member?
  (lambda (a l)
    (cond
      ((or (null? a) (null? l)) #f)
      ((eq? a (car l)) #t)
      (else (member? a (cdr l)))
    )
  )
)

(define member??
  (lambda (a lat)
    (cond
      ((null? lat) #f)
      (else (or (eq? (car lat) a)
                (member?? a (cdr lat)))))))


(define rember
  (lambda (a lat)
    (cond
      ((null? lat) '())
      ((eq? a (car lat)) (cdr lat))
      (else (cons (car lat) (rember a (cdr lat)))))
  )
)

(define firsts
  (lambda (l)
    (cond
      ((null? l) '())
      ((cons (car (car l)) (firsts (cdr l))))
    )
  )
)
(define firstss
  (lambda (l)
    (cond
      ((null? l) '())
      (cons (cond              
              ((atom? (car l)) (car l))              
              ((firstss (car l)))
             )
            (firstss (cdr l)))
      )
    )
  )

(firsts '((apple peach pumpkin) (plum pear cherry) (grape raisin pea) (bean carrot eggplant)))
(println '>>>>>>>>>>>>)
(firstss '((apple peach pumpkin) (plum pear cherry) (grape raisin pea) (bean carrot eggplant)))

(define insertR
  (lambda (new old lat)
    (cond
      ((null? lat) '())      
      (else
        (cond
          ((eq? (car lat) old) (cons old (cons new (cdr lat))))
          (else (cons (car lat) (insertR new old (cdr lat))))
        )
      )
    )
  )
)

(insertR 'e 'd '(a b c d f g d h))

(define insertL
  (lambda (new old lat)
    (cond
      ((null? lat) '())      
      (else
        (cond
          ((eq? (car lat) old) (cons new (cons old (cdr lat))))
          (else (cons (car lat) (insertL new old (cdr lat))))
        )
      )
    )
  )
)

(insertL 'e 'd '(a b c d f g d h))

(define multirember
  (lambda (a lat)
    (cond
      ((null? lat) '())
      ((eq? a (car lat)) (multirember a (cdr lat)))
      (else (cons (car lat) (multirember a (cdr lat))))
    )
  )
)
(multirember 'cup '(coffee cup tea cup and hick cup))

(define multiinsertR
  (lambda (new old lat)
    (cond
      ((null? lat) '())
      ((eq? (car lat) old) (cons old (cons new (multiinsertR new old (cdr lat)))))
      (else (cons (car lat) (multiinsertR new old (cdr lat))))
    )
  )
)
(multiinsertR 'x 'i '(a b i d e i))



(define multiinsertL
  (lambda (new old lat)
    (cond
      ((null? lat) '())
      ((eq? (car lat) old) (cons new (cons old (multiinsertL new old (cdr lat)))))
      (else (cons (car lat) (multiinsertL new old (cdr lat))))
    )
  )
)
(multiinsertL 'x 'i '(a b i d e i))

(define subset
  (lambda (new old lat)
    (cond
      ((null? lat) '())
      ((eq? (car lat) old) (cons new (cdr lat)))
      (else (cons (car lat) (subset (new old (cdr lat)))))
    )
  )
)  

(define multisubset
  (lambda (new old lat)
    (cond
      ((null? lat) '())
      ((eq? (car lat) old) (cons new (multisubset new old (cdr lat))))
      (else (cons (car lat) (multisubset (new old (cdr lat)))))
    )
  )
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(define add1
  (lambda (n)
  (+ 1 n)))
(add1 3)
(define sub1
  (lambda (n)
    (- n 1)))
(sub1 3)

(define plus
  (lambda (a b)
    (cond
      ((zero? a) b)
      (else (plus (sub1 a) (add1 b))))))
(plus 1 2)

(define addtup
  (lambda (tup)
    (cond
      ((null? tup) 0)
      (else
        (+ (car tup) (addtup (cdr tup)))
      )
    )
  )
)
(addtup '(1 2 3))

(define mul
  (lambda (n m)
    (cond
      ((zero? m) 0)
      (else (+ n (mul n (sub1 m)))))))

(mul 2 9)

(define tup+
  (lambda (t1 t2)
    (cond
      ;((and (null? t1) (null? t2)) '())
      ((null? t1) t2)
      ((null? t2) t1)
      (else
       (cons (+ (car t1) (car t2)) (tup+ (cdr t1) (cdr t2)))
      )
    )
  )
)
(tup+ '(1 2 6) '(3 4))

(define bigger
  (lambda (m n)
    (cond
      ((zero? m) #f)
      ((zero? n) #t)
      (else
       (bigger (sub1 m) (sub1 n))))))
(define smaller
    (lambda (m n)
    (cond
      ((zero? m) #t)
      ((zero? n) #f)
      (else
       (smaller (sub1 m) (sub1 n))))))
(bigger 2 3)
(smaller 2 3)

(define divide
  (lambda (n m)
    (cond
      ((< n m) 0)
      (else (add1 (/ (- n m) m))))))

(divide 15 4)

(define length
  (lambda (lat)
    (cond
      ((null? lat) 0)
      (else (add1 (length (cdr lat)))))))
(length '(1 2 3 4 5))



(define pick
  (lambda (n lat)
    (cond
      ((zero? n) '())
      ((eq? n 1) (car lat))
      (else (pick (sub1 n) (cdr lat)))
    )
  )
)
(pick 3 '(a b c d e f))

(define rempick
  (lambda (n lat)
    (cond
      ((zero? (sub1 n)) (cdr lat))
      (else (cons (car lat)
                  (rempick (sub1 n) (cdr lat)))))
  )
)

(define no-nums
  (lambda (lat)
    (cond
      ((null? lat) '())
      (else (cond
              ((number? (car lat))
                (no-nums (cdr lat)))
              (else (cons (car lat) (no-nums (cdr lat)))))))))


;；；；；；；；；；；；；；；；；；；；；；；；；；；；
(define rember*
  (lambda (a l)
    (cond
      ((null? l) '())
      ((eq? a (car l)) (rember* a (cdr l)))
      (else (cons (cond
                    ((list? (car l)) (rember* a (car l)))
                    (else (car l)))
                  (rember* a (cdr l)))))))
(define rember0*
  (lambda (a l)
    (cond
      ((null? l) '())
      ((atom? (car l))
        (cond
         ((eq? a (car l)) (rember* a (cdr l)))
         (else (cons (car l) (rember* a (cdr l))))))
      (else (cons (rember* a (car l)) (rember* a (cdr l)))))))

(rember* 'cup '((coffee) cup ((tea) cup) (and (hick)) cup))
(rember0* 'cup '((coffee) cup ((tea) cup) (and (hick)) cup))


(define insertR*
  (lambda (new old l)
    (cond
      ((null? l) '())
      ((atom? (car l))
       (cond
         ((eq? (car l) old) (cons old (cons new (insertR* new old (cdr l)))))
         (else
          (cons (car l) (insertR* new old (cdr l))))))
      (else (cons (insertR* new old (car l)) (insertR* new old (cdr l))))
    )
  )
)

(insertR* 'roast 'chuck '((how much (wood))
                          could
                          ((a (wood) chuck))
                          (((chuck)))
                          (if (a) ((wood chuck)))
                          could chuck wood))

(define occur*
  (lambda (a l)
      (cond
        ((null? l) 0)
        ((atom? (car l))
         (cond
           ((eq? a (car l)) (add1 (occur* a (cdr l))))
           (else (occur* a (cdr l)))))
        (else (+ (occur* a (car l)) (occur* a (cdr l))))
      )
    )
  )
(occur* 'banana '((banana) (split ((((banana ice))) (cream (banana)) sherbet)) (banana) (bread) (banana brandy)))

(define leftmost
  (lambda (l)
    (cond
      ((atom? (car l)) (car l))
      (else (leftmost (car l))))))

(define eqlist?
  (lambda (l1 l2)
    (cond
      ((and (null? l1) (null? l2)) #t)
      ((and (atom? (car l1)) (atom? (car l2)))
       (cond
         ((eq? (car l1) (car l2)) (eqlist? (cdr l1) (cdr l2)))
         (else #f)))
      ((and (list? (car l1)) (list? (car l2)))
       (eqlist? (car l1) (car l2)))
      (else #f)
    )
  )
)
(eqlist? '(banana ((split))) '((banana) (split)))
(eqlist? '(beef ((sausage)) (and (soda))) '(beef ((sausage)) (and (soda))))

(define eqlist??
  (lambda (l1 l2)
    (cond
      ((and (null? l1) (null? l2)) #f)
      ((or (null? l1) (null? l2)) #f)
      ((and (atom? (car l1))
            (atom? (car l2)))
       (and (eqan? (car l1) (car l2))
            (eqlist?? (cdr l1) (cdr l2))))
      ((or (atom? (car l1)) (atom? (car l2))) #f)
      (else
       (and (eqlist?? (car l1) (car l2)) (eqlist?? (cdr l1) (cdr l2)))))))

(define equal?
  (lambda (s1 s2)
    (cond
      ((and (atom? s1) (atom? s2))
       (eqan? s1 s2))
      ((or (atom? s1) (atom? s2)) #f)
      (else (eqlist? s1 s2)))))

(define eqan?
  (lambda (a1 a2)
    (cond
      ((and (number? a1) (number? a2)) (= a1 a2))
      ((or (number? a1) (number? a2)) #f)
      (else (eq? a1 a2)))))

(define numbered?
  (lambda (aexp)
    (cond
      ((atom? aexp) (number? aexp))
      (else
       (and (numbered? (car aexp))
            (numbered? (car (cdr (cdr aexp)))))))))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(println '>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>)
(define set?
  (lambda (lat)
    (cond
      ((null? lat) #t)
      (else
        (cond
          ((member? (car lat) (cdr lat)) #f)
          (else (set? (cdr lat)))
        )
      )
    )
  )
)

(set? '(apple peaches apple plun))
(set? '(apple peaches plun))

(define makeset
  (lambda (lat)
    (cond
      ((null? lat) '())
      ((member? (car lat) (cdr lat)) (makeset (cdr lat)))
      (else (cons (car lat) (makeset (cdr lat))))
    )
  )
)