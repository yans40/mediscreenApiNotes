db.notes.deleteMany({})
db.notes.insertMany([
    {
        patientId: 1,
        observation: "Le patient déclare qu'il se sent très bien. poids égal ou inférieur au poids recommandé",
        date: new Date()
    },
    {
        patientId: 2,
        observation: "Le patient déclare qu'il ressent beaucoup de stress au travail.Il se plaint également que son audition est anormale",
        date: new Date()
    },
    {
        patientId: 2,
        observation: "Le patient déclare avoir fait une réaction aux médicaments au cours des 3 derniers mois.Il remarque également que son audition continue d'être anormale",
        date: new Date()
    },
    {
        patientId: 3,
        observation: "Le patient déclare que c'est un fumeur depuis peu",
        date: new Date()
    },
    {
        patientId: 3,
        observation: "Le patient déclare qu'il est fumeur et qu'il a cessé de fumer l'année dernière.Il se plaint également de crises d’apnée respiratoire anormale.Tests de laboratoire indiquant un taux de cholestérol LDL élevé",
        date: new Date()
    },
    {
        patientId: 4,
        observation: "Le patient déclare qu'il lui est devenu difficile de monter les escaliers.Il se plaint également d’être essoufflé.Tests de laboratoire indiquant que les anticorps sont élevés.réaction aux médicaments",
        date: new Date()
    },
    {
        patientId: 4,
        observation: "Le patient déclare qu'il a mal au dos lorsqu'il reste assis pendant longtemps",
        date: new Date()
    },
    {
        patientId: 4,
        observation: "Le patient déclare être un fumeur depuis peu.hémoglobine A1C supérieure au niveau recommandé",
        date: new Date()
    },
    {
        patientId: 4,
        observation: "Le patient déclare que la taille du corps, le poids corporel, le vertige et réaction ",
        date: new Date()
    },
    {
        patientId: 5,
        observation: "Le patient déclare qu'il se sent très bien. poids égal ou inférieur au poids recommandé ",
        date: new Date()
    },
    {
        patientId: 5,
        observation: "Le patient déclare qu'il se sent fatigué pendant la journée. iL se plaint également de douleurs musculaires." +
            "Tests de laboratoire indiquant une microalbumine élevée "
    },
    {
        patientId: 5,
        observation: "Le patient déclare qu'il ne se sent pas si fatigués que ça ;fumeur il a arrêté dans les 12 mois précédents test de laboratoire indiquant que les anticorps sont élevés "
    },
    {
        patientId: 6,
        observation: "Le patient déclare qu'il ressent beaucoup de stress au travail.Il se plaint également que son audition est anormale patient dernièrement"
    },

    {
        patientId: 6,
        observation: "Le patient déclare avoir fait une réaction aux médicaments au cours des 3 derniers mois.Il remarque également que son audition continue d'être anormale"
    },
    {
        patientId: 6,
        observation: "Tests de laboratoire indiquant microalbumine élevée"
    },
    {
        patientId: 6,
        observation: "Le patient déclare que tout semble aller bien le laboratoire rapporte que l'hémoglobine A1C dépasse le niveau recommandé le patient déclare qu'il fume depuis longtemps "
    },
    {
        patientId: 7,
        observation: "le patient déclare qu'il fume depuis peu"
    },
    {
        patientId: 7,
        observation: "Tests de laboratoire indiquant microalbumine élevée"
    },
    {
        patientId: 7,
        observation: "Le patient déclare qu'il est fumeur et qu'il a cessé de fumer l'année dernière il se plaint également de crise d'apnée respiratoire anormale test de laboratoire indiquant un taux de cholestérol LDL élevé "
    },
    {
        patientId: 7,
        observation: "Tests de laboratoire indiquant un taux de cholestérol LDL élevé"
    },
    {
        patientId: 8,
        observation: "Le patient déclare qu'il lui est devenu difficile de monter les escaliers.Il se plaint également d’être essoufflé.Tests de laboratoire indiquant que les anticorps sont élevés.réaction aux médicaments"
    },
    {
        patientId: 8,
        observation: "TLe patient déclare qu'il a mal au dos  lorsqu'il reste assis pendant longtemps"
    },
    {
        patientId: 8,
        observation: "le déclare avoir commencé à fumer depuis peu. hémoglobine A1C supérieure au niveau recommandé"
    },
    {
        patientId: 9,
        observation: "Le patient déclare avoir des douleurs au cou occasionnellement. Le patient remarque également que certains aliments ont un goût différent. réaction apparente aux médicaments ." +
            "poids corporel supérieur au poids recommandé"
    },
    {
        patientId: 9,
        observation: "Le patient déclare avoir eu plusieurs épisode de vertiges depuis la dernière visite. taille incluse dans la fourchette concernée"
    },
    {
        patientId: 9,
        observation: "le patient déclare qu'il souffre de  douleurs cervicales occasionnelles" +
            "Tests de laboratoire indiquant une microalbumine élevée " +
            "fumeur il a arrêté dans les 12 derniers mois précédents"
    },
    {
        patientId: 9,
        observation: "Le patient déclare avoir eu plusieurs épisodes de vertiges depuis la dernière visite un test de laboratoire indiquant que les anticorps sont élevés"
    },
    {
        patientId: 10,
        observation: "le patient déclare qu'il se sent bien poids corporel supérieur au poids recommandé"
    }, {
        patientId: 10,
        observation: "le patient déclare qu'il se sent bien "
    }, {
        patientId: 11,
        observation: "le patient déclare qu'il se réveille souvent avec une raideur articulaire il se plaint également de difficultés pour s'endormir pour un corporel supérieur au poids recommandé un test de laboratoire indiquant un taux de cholestérol elle LDL élevé"
    }, {
        patientId: 12,
        observation: "les tests de laboratoire indiquent que les anticorps sont élevés hémoglobine A1C supérieur au niveau recommandé"
    }, {
        patientId: 13,
        observation: "le patient déclare avoir de la difficulté à se concentrer sur ses devoirs scolaires hémoglobine A1C supérieur au niveau recommandé"
    }, {
        patientId: 13,
        observation: "le patient déclare qu'il s'impatiente facilement en cas d'attente prolongée il signale également que tous les produits du distributeur automatique ne sont pas bons test de laboratoire signalant des taux anormaux de cellules sanguines"
    }, {
        patientId: 13,
        observation: "le patient signale qu'il est facilement irrité par des broutilles il déclare également que l'aspirateur des voisins fait trop de bruit test de laboratoire indiquant que les anticorps sont élevés"
    }, {
        patientId: 14,
        observation: "le patient déclare qu'il n'a aucun problème"
    }, {
        patientId: 14,
        observation: "le patient déclare qu'il n'a aucun problème la taille incluse dans la fourchette concernée hémoglobine A1C supérieur au niveau recommandé"
    }, {
        patientId: 14,
        observation: "le patient déclare qu'il n'a aucun problème poids corporel supérieur au poids recommandé le patient a signalé plusieurs épisodes de vertiges depuis sa dernière visite"
    },
    {
        patientId: 14,
        observation: "le patient déclare qu'il n'a aucun problème vitesse de laboratoire indiquant une microalbumine élevée"
    },
]);