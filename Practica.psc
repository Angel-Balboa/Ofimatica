Algoritmo Promedio
	Definir prom,i,cal,total Como Real
	prom<-0
	i<-1
	cal<-0
	total<-0
	Para i<-1 Hasta 10 Con Paso 1 Hacer
		Escribir 'Ingrese la calificación número ',i
		Leer cal
		total<-total+cal
	Fin Para
	prom<-total/10
	Escribir 'El promedio es: 'prom
FinAlgoritmo
