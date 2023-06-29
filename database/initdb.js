db.notes.deleteMany({})
db.notes.insertMany([
    {
        patientId: 1,
        observation: "cholestérol,vertige",
        date: new Date()
    },
    {
        patientId: 1,
        observation: "fumeur,taille,cholestérol,vertige",
        date: new Date()
    },
    {
        patientId: 2,
        observation: "vertige",
        date: new Date()
    },
    {
        patientId: 3,
        observation: "réaction",
        date: new Date()
    },
    {
        patientId: 4,
        observation: "microalbumine,anticorps",
        date: new Date()
    },
    {
        patientId: 5,
        observation: "fumeur,poids",
        date: new Date()
    },
    {
        patientId: 6,
        observation: "fumeur",
        date: new Date()
    }
]);