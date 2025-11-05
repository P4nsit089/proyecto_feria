# 🏨 Sistema de Reservas de Hotel

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-Project-blue.svg)](https://maven.apache.org/)
[![Swing](https://img.shields.io/badge/GUI-Swing-green.svg)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![FlatLaf](https://img.shields.io/badge/Theme-FlatLaf-blueviolet.svg)](https://www.formdev.com/flatlaf/)

## 📋 Descripción

Sistema de gestión de reservas hoteleras desarrollado por estudiantes de 7mo año de la Tecnicatura en Informática. Este proyecto será presentado en **ExpoGalileo 2025**, la feria de ciencias de nuestra institución, el día **14 de noviembre de 2025**.

El sistema permite la administración completa de reservas de habitaciones de hotel a través de una interfaz gráfica moderna e intuitiva, construida con Java Swing y estilizada con FlatLaf para ofrecer una experiencia de usuario profesional.

## ✨ Características

- 🔐 Gestión de clientes y sus datos personales
- 🛏️ Administración de habitaciones del hotel
- 📅 Sistema de reservas con control de disponibilidad
- 🎨 Interfaz gráfica moderna usando Swing y FlatLaf
- 📊 Visualización y gestión de listas de clientes y reservas
- 💾 Persistencia de datos

## 🚀 Tecnologías Utilizadas

- **Java 17** - Lenguaje de programación
- **Maven** - Gestión de dependencias y construcción del proyecto
- **Swing** - Framework para interfaz gráfica
- **FlatLaf** - Look and Feel moderno para Swing

## 📁 Estructura del Proyecto

```
proyecto_feria/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── Cliente.java          # Clase modelo de Cliente
│   │   │   ├── Habitacion.java       # Clase modelo de Habitación
│   │   │   ├── Reserva.java          # Clase modelo de Reserva
│   │   │   ├── listaClientes.java    # Gestión de clientes
│   │   │   ├── ListaReservas.java    # Gestión de reservas
│   │   │   └── Main.java             # Punto de entrada de la aplicación
│   │   └── resources/
│   └── test/
│       └── java/
├── pom.xml                            # Configuración de Maven
└── README.md
```

## 🛠️ Instalación y Configuración

### Requisitos Previos

- Java Development Kit (JDK) 17 o superior
- Apache Maven 3.6 o superior
- Un IDE compatible con Java (Eclipse, VS Code, IntelliJ IDEA)

### Pasos de Instalación

1. **Clonar el repositorio**

   ```bash
   git clone https://github.com/NahueDB/proyecto_feria.git
   cd proyecto_feria
   ```
2. **Compilar el proyecto**

   ```bash
   mvn clean compile
   ```
3. **Ejecutar la aplicación**

   ```bash
   mvn exec:java -Dexec.mainClass="Main"
   ```

## 💻 Uso del Sistema

1. **Inicio de la Aplicación**: Ejecutar la clase `Main.java`
2. **Gestión de Clientes**: Agregar, modificar y consultar información de clientes
3. **Gestión de Habitaciones**: Administrar las habitaciones disponibles del hotel
4. **Realizar Reservas**: Asignar habitaciones a clientes según disponibilidad
5. **Consultar Reservas**: Visualizar y gestionar las reservas existentes

## 👥 Equipo de Desarrollo

Proyecto desarrollado por estudiantes de 7mo año de la Tecnicatura en Informática.

## 📅 ExpoGalileo 2025

Este proyecto será presentado en la feria de ciencias **ExpoGalileo 2025** el día **14 de noviembre de 2025**.

### Objetivos del Proyecto

- Aplicar conocimientos de Programación Orientada a Objetos
- Desarrollar una aplicación con interfaz gráfica profesional
- Implementar un sistema de gestión de datos robusto
- Trabajar en equipo en un proyecto de desarrollo de software

## 🤝 Contribuciones

Este es un proyecto educativo desarrollado por estudiantes. Las sugerencias y mejoras son bienvenidas.

---

**Desarrollado con ❤️ por estudiantes de 7mo año - Tecnicatura en Informática**

*Proyecto presentado en ExpoGalileo 2025 - 14/11/2025*
