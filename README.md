# Fullstack Collections Management Game

Ein interaktives Fullstack-Webanwendung zur Verwaltung von Sammlungen (Collections) mit verschiedenen Datenstruktur-Implementierungen. Das Projekt demonstriert praktische Anwendungen von List, Set, Queue und Stack mit einer benutzerfreundlichen Web-Oberfläche.

## 🎯 Features

- **Multiple Collection-Typen**: Unterstützung für verschiedene Datenstrukturen (List, Set, Queue, Stack)
- **Stadt-Management**: Hinzufügen, Löschen und Verwalten von Städten in unterschiedlichen Datenstrukturen
- **Routing-Funktionen**: Berechnung von optimierten Routen durch Städte
- **Responsive UI**: HTML/CSS-basierte Benutzeroberfläche
- **REST API**: Spring Boot Backend mit RESTful Endpoints

## 🛠️ Technologie-Stack

| Technologie | Anteil | Verwendung |
|-------------|--------|-----------|
| Java | 40.4% | Spring Boot Backend, Business-Logik |
| HTML | 45.6% | Frontend & UI |
| CSS | 14% | Styling & Design |

## 📁 Projekt-Struktur

```
src/
├── Backend/
│   ├── connect.java          # REST Controller
│   ├── CollectionService.java # Business-Logik
│   └── ... weitere Backend-Komponenten
├── Frontend/
│   ├── index.html            # Hauptseite
│   ├── style.css             # Styling
│   └── ... weitere HTML-Dateien
└── ... weitere Dateien
```

## 🚀 Funktionen & API-Endpoints

### Verfügbare REST-Endpoints

#### Collections Abfragen
- **GET** `/getConnection` - Städte einer bestimmten Collection abrufen
- **GET** `/getConnection/types` - Verfügbare Collection-Typen auflisten

#### Stadt-Verwaltung
- **POST** `/getConnection/newCity` - Neue Stadt hinzufügen
- **DELETE** `/getConnection/city` - Stadt entfernen
- **GET** `/getConnection/contains` - Prüfe ob Stadt existiert
- **GET** `/getConnection/size` - Größe der Collection abrufen

#### Routing
- **GET** `/getConnection/route` - Einfache Route abrufen
- **GET** `/getConnection/route/ordered` - Optimierte Route mit Sortierung

### Request-Parameter

| Parameter | Typ | Beschreibung | Standard |
|-----------|-----|-------------|---------|
| `rawType` | String | Collection-Typ (list/set/queue/stack) | "list" |
| `city` | String | Stadtname | - |
| `order` | String | Sortierreihenfolge | "input" |

## 💻 Verwendung

### Backend starten
```bash
# Spring Boot Anwendung starten
./mvnw spring-boot:run
```

Der Server läuft auf `http://localhost:8080`



## 📝 Beispiele

### Stadt hinzufügen
```
POST /getConnection/newCity?rawType=list&city=Berlin
```

### Verfügbare Typen abrufen
```
GET /getConnection/types
```

### Route mit Sortierung
```
GET /getConnection/route/ordered?rawType=list&order=alphabetic
```

## 🎮 Spielmechanik

Die Anwendung ermöglicht es, verschiedene Datenstrukturen praktisch zu verstehen:
- **List**: Geordnete Sammlung mit Duplikaten
- **Set**: Einzigartige Elemente ohne Sortierung
- **Queue**: FIFO-Prinzip (First In, First Out)
- **Stack**: LIFO-Prinzip (Last In, First Out)

## Hinweis 
- Das Verbinden zwischen Backend und Frontend geht noch nicht 

## 📋 Anforderungen

- Java 11+
- Spring Boot 2.x+
- Maven oder Gradle
- Moderner Browser (Chrome, Firefox, Safari, Edge)

## 🤝 Beitragen

Contributions sind willkommen! Bitte öffne einen Pull Request mit deinen Verbesserungen.

## 📄 Lizenz

Dieses Projekt ist Open Source und frei verfügbar.

---

**Autor**: Tony200314  
**Repository**: [Fullstack-Collections-Management-Game-](https://github.com/Tony200314/Fullstack-Collections-Management-Game-)
