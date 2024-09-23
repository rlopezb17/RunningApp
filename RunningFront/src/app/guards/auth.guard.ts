import { CanActivateFn } from '@angular/router';
import { inject } from '@angular/core';
import { Router } from '@angular/router';

// Función para decodificar el token y obtener su payload
const decodeToken = (token: string): any => {
  try {
    const payload = token.split('.')[1];
    return JSON.parse(atob(payload));
  } catch (e) {
    return null;
  }
};

// Función para verificar si el token ha expirado
const isTokenExpired = (token: string): boolean => {
  const decoded = decodeToken(token);
  if (!decoded || !decoded.exp) {
    return true; // Si no hay fecha de expiración, el token se considera inválido
  }
  const now = Math.floor(new Date().getTime() / 1000); // Tiempo actual en segundos
  return decoded.exp < now;
};

export const authGuard: CanActivateFn = (route, state) => {
  const token = localStorage.getItem('token');

  if (token) {
    // Verificar si el token ha expirado
    if (isTokenExpired(token)) {
      localStorage.removeItem('token'); // Eliminar el token si está expirado
      const router = inject(Router);
      router.navigate(['/login']); // Redirigir al login
      return false;
    }

    return true; // Si el token es válido, permitir el acceso
  } else {
    const router = inject(Router);
    router.navigate(['/login']); // Si no hay token, redirigir al login
    return false;
  }
};
