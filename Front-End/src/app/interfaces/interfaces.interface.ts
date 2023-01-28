export interface IPrestamos {
  idprestamo: number;
  monto: number;
  interes: number;
  cuotas: number;
  fechaprestamo: Date;
}


export interface IUsuarios {
  id: number;
  firstname: string;
  lastname: string;
}


export interface IPrestamoPost {
  monto: number;
  cuotas: number;
  userId: number;
}
