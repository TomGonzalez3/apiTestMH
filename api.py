from flask import Flask, jsonify
import os

app = Flask(__name__)

@app.route('/api/credenciales', methods=['GET'])
def get_credenciales():
    db_user = os.getenv('DB_USER', 'default_user')
    db_password = os.getenv('DB_PASSWORD', 'default_password')

    return jsonify({
        "user": db_user,
        "password": db_password
    })

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
