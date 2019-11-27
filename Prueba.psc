Algoritmo sin_titulo
	Definir prom,cal,i,total Como Real
	cal<-0
	prom<-0
	i<-0
	total<-0
	Repetir
		Escribir 'Ingrese la calificacion '
		Leer cal
		total<-total+cal
		i=i+1
	Hasta Que i=5
	prom<-total/5
	Escribir 'El promedio es: ',prom
FinAlgoritmo
