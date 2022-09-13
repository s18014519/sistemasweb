const doGet = (e = {}) => {
    const { parameter } = e;
    const { nombre = 'Arnold', apellido = 'GetSchwarzenegger', direccion = '', telefono = '' } = parameter;
    const salida = `Hola ${nombre} ${apellido} ${direccion} ${telefono}`;
    return ContentService.createTextOutput(salida);
};
// regresa de forma textual los parámetros leidos con post
const doPost = (e = {}) => {
    const { parameter } = e;
    const { nombre = 'Arnold', apellido = 'PostSchwarzenegger' } = parameter;
    const salida = `Hola ${nombre} ${apellido}`;
    return ContentService.createTextOutput(salida);
};